from google import genai
import os
from app.core.prompt_builder import build_gemini_prompt
# from core.prompt_builder import build_gemini_prompt
from dotenv import load_dotenv

load_dotenv()

client = genai.Client(
    api_key = os.getenv("GEMINI_API_KEY")
)


async def analyze_with_gemini(code: str):
    try:
        prompt = build_gemini_prompt(code)

        response = client.models.generate_content(
            model="gemini-2.5-flash",
            contents=prompt,
            config={
                "temperature": 0.2,
                "top_p": 0.9,
                "max_output_tokens": 2048
            }
        )

        return response.text

    except Exception as e:
        return f"Gemini error: {str(e)}"