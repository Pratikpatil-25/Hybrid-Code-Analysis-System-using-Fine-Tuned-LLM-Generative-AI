def build_gemini_prompt(code: str):
    return f"""
You are an expert code reviewer.
Code:
{code}
Return ONLY valid JSON.
No markdown.
No explanation.
No text before or after JSON.
### Output Format (STRICT):
{{
"Explanation": "",
"bugs": "",
"Suggestions": "",
}}

"""


def build_codellama_prompt(code: str):
    return f"""
You are a strict JSON generator.
Analyze the code and return ONLY this JSON:
{{
  "time_complexity": "O(...)",
  "space_complexity": "O(...)",
  "algorithm_category": "..."
}}
Rules:
- Do NOT add explanation
- Always give exact Big-O
- Never return O(...)
- Do NOT add text before or after JSON
- Output must start with {{ and end with }}
Code:
{code}
"""
