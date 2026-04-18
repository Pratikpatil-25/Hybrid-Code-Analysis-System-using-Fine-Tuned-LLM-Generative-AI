from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
import os
from dotenv import load_dotenv
import google.generativeai as genai
from finetuning_prompt import build_prompt

# Load environment variables
load_dotenv()

# Configure Gemini API
genai.configure(api_key=os.getenv("GEMINI_API_KEY"))

# Initialize model (Flash = fast + efficient)
model = genai.GenerativeModel("gemini-2.5-flash")

app = FastAPI(title="Code Insight AI Engine (Gemini)")

# Request model
class CodeRequest(BaseModel):
    code: str

@app.post("/analyze")
async def analyze_code(request: CodeRequest):
    try:
        # Step 1: Build prompt
        prompt = build_prompt(request.code)

        # Step 2: Generate response
        response = model.generate_content(
            prompt,
            generation_config={
                "temperature": 0.2,  # consistent output
                "top_p": 0.9,
                "max_output_tokens": 1024
            }
        )

        return {
            "status": "success",
            "analysis": response.text
        }

    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))