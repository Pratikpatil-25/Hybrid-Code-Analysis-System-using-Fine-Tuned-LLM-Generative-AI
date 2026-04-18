import requests
from app.core.prompt_builder import build_codellama_prompt
# from core.prompt_builder import build_codellama_prompt

CODLLAMA_URL = "http://localhost:11434/api/generate"

def analyze_with_codellama(code: str):
    prompt = build_codellama_prompt(code)

    payload = {
        "model": "phi",
        "prompt": prompt,
        "stream": False
    }

    try:
        response = requests.post(CODLLAMA_URL, json=payload, timeout=60)

        if response.status_code != 200:
            return f"Ollama HTTP error: {response.status_code} - {response.text}"

        data = response.json()

        if "response" in data and data["response"].strip():
            return data["response"]

        return f"Ollama empty response: {data}"

    except Exception as e:
        return f"CodeLlama service error: {str(e)}"
