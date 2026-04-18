import os
import random
import json
import time
from tqdm import tqdm
from google import genai

# 🔑 API KEY
client = genai.Client(api_key="AIzaSyD6MAtIrVbeGdq4czYZB8R84JnQ4UPmtsQ")

# 🔹 FOLDERS + CATEGORY
folders = {
    "java_data": "general",
    "java_data_search": "search",
    "java_data_sort": "sorting",
    "java_data_recursion": "recursion"
}

# 🔹 SETTINGS
BATCH_SIZE = 5   # ⚠️ keep small to avoid token overflow

# 🔹 READ FILES
all_samples = []

for folder, category in folders.items():
    if not os.path.exists(folder):
        continue

    for file in os.listdir(folder):
        if file.lower().endswith((".txt", ".java")):
            path = os.path.join(folder, file)

            with open(path, "r", encoding="utf-8") as f:
                code = f.read()

            all_samples.append({
                "id": f"{folder}_{file}",
                "code": code,
                "category": category
            })

print(f"Total files: {len(all_samples)}")

# 🔹 CREATE BATCHES
def create_batches(data, batch_size):
    for i in range(0, len(data), batch_size):
        yield data[i:i + batch_size]

# 🔹 PROMPT FOR BATCH
def create_batch_prompt(batch):
    prompt = """
You are an expert in algorithm analysis.

Analyze each Java code and return ONLY valid JSON array.

Format:
[
  {
    "id": "same id",
    "time_complexity": "",
    "space_complexity": "",
    "explanation": "",
    "optimization": ""
  }
]

Rules:
- Output must be valid JSON array
- DO NOT add extra text
- Each object must match input id

Codes:
"""

    for item in batch:
        prompt += f"\nID: {item['id']}\nCODE:\n{item['code']}\n"

    return prompt

# 🔹 CALL API
def call_gemini(prompt, max_retries=5):
    for attempt in range(max_retries):
        try:
            response = client.models.generate_content(
                model="gemini-2.5-flash",
                contents=prompt
            )

            text = response.text.strip()

            # Clean markdown
            if text.startswith("```"):
                text = text.replace("```json", "").replace("```", "").strip()

            return json.loads(text)

        except Exception as e:
            print(f"⚠️ Attempt {attempt+1} failed:", e)

            # If last attempt → give up
            if attempt == max_retries - 1:
                return None

            # 🔥 Exponential backoff
            wait_time = (2 ** attempt) + random.uniform(1, 3)
            print(f"⏳ Retrying in {wait_time:.2f} sec...")
            time.sleep(wait_time)

# 🔹 MAIN PROCESS
final_dataset = []

batches = list(create_batches(all_samples, BATCH_SIZE))

for batch in tqdm(batches, desc="Processing Batches"):
    prompt = create_batch_prompt(batch)
    result = call_gemini(prompt)

    if result is None:
        print("❌ Batch failed permanently. Saving for retry later.")
    
        with open("failed_batches.txt", "a") as f:
            f.write(str([item["id"] for item in batch]) + "\n")
    
        continue

    # Map results
    result_map = {item["id"]: item for item in result}

    for item in batch:
        res = result_map.get(item["id"], {})

        formatted = {
            "instruction": "Analyze the Java code.",
            "input": item["code"],
            "output": {
                "time_complexity": res.get("time_complexity", ""),
                "space_complexity": res.get("space_complexity", ""),
                "explanation": res.get("explanation", ""),
                "optimization": res.get("optimization", "")
            },
            "category": item["category"]
        }

        final_dataset.append(formatted)

    # ⏳ Rate limit safety
    time.sleep(2)

# 🔹 SAVE
with open("final_dataset.json", "w", encoding="utf-8") as f:
    json.dump(final_dataset, f, indent=2)

print(f"\n✅ Done! Total samples: {len(final_dataset)}")