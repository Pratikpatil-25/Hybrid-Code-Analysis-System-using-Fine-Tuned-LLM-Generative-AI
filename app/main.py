from fastapi import FastAPI
from app.api.routes import router
# from main.api.routes import router

app = FastAPI(
    title="Code Insight AI Engine (Hybrid Gemini + CodeLlama)",
    version="2.0"
)

app.include_router(router)

@app.get("/")
def root():
    return {"message": "Hybrid AI Engine is running"}