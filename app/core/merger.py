import json
from app.utils.json_parser import parse_llm_output
# from utils.json_parser import parse_llm_output


def merge_outputs(gemini_output: str, codellama_output: str):
    gemini_json = parse_llm_output(gemini_output)
    codellama_json = parse_llm_output(codellama_output)

    return {
        "status": "success",
        "gemini_analysis": gemini_json,
        "llama_analysis": codellama_json,
        "combined_view": {
            "summary": gemini_json.get("raw_output"),
            "time": codellama_json.get("time_complexity", ""),
            "space": codellama_json.get("space_complexity", "")
        }
    }
    # return final_response