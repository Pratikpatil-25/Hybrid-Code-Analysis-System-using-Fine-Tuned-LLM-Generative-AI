import json
import re


def extract_json_block(text: str):
    """
    Extract first valid JSON object from messy LLM output
    """

    # Find first { ... }
    match = re.search(r"\{.*?\}", text, re.DOTALL)
    if match:
        return match.group(0)

    return text


def safe_json_loads(text: str):
    """
    Safely convert LLM output to JSON.
    """

    try:
        return json.loads(text)
    except Exception:
        return None


def repair_json_string(text: str):
    """
    Try to fix common LLM JSON issues.
    """

    # Remove trailing commas
    text = re.sub(r",\s*}", "}", text)
    text = re.sub(r",\s*]", "]", text)

    return text


def parse_llm_output(text: str):
    """
    Main parser used by Gemini + CodeLlama outputs
    """

    if not text:
        return {"error": "empty_response"}

    # Step 1: extract JSON region
    extracted = extract_json_block(text)

    # Step 2: repair common formatting issues
    repaired = repair_json_string(extracted)

    # Step 3: try parsing
    parsed = safe_json_loads(repaired)

    if parsed is not None:
        return parsed

    # Step 4: fallback response
    return {
        "error": "invalid_json",
        "raw_output": text
    }