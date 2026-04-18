from fastapi import APIRouter, HTTPException
from app.schemas.request import CodeRequest
from app.services.gemini_service import analyze_with_gemini
from app.services.codellama_service import analyze_with_codellama
from app.core.merger import merge_outputs
# from schemas.request import CodeRequest
# from services.gemini_service import analyze_with_gemini
# from services.codellama_service import analyze_with_codellama
# from core.merger import merge_outputs

router = APIRouter()


@router.post("/analyze")
async def analyze_code(request: CodeRequest):
    try:
        try:
            gemini_result = await analyze_with_gemini(request.code)
        except Exception as e:
            gemini_result = f"Gemini error: {str(e)}"

        try:
            codellama_result = analyze_with_codellama(request.code)
        except Exception as e:
            codellama_result = f"CodeLlama error: {str(e)}"

        final = merge_outputs(gemini_result, codellama_result)

        return final

    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))