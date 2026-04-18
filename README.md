# 🚀 Code Insight: Hybrid AI Code Analysis Engine  

## 📌 Overview  
**Code Insight** is an AI-powered code analysis system designed to evaluate programming solutions beyond simple correctness. It leverages a **hybrid AI architecture** combining **Generative AI** and a **fine-tuned Large Language Model (LLM)** to provide deep insights into code quality, efficiency, and structure.

This project is built as part of an **educational coding platform** to enhance learning outcomes by delivering **intelligent, explainable feedback** to students.

---

## 🧠 AI Component (Core Innovation)

The AI engine is built on a **Hybrid Approach**:

### 🔹 1. Generative AI (Gemini API)
- Provides **human-like explanations**
- Converts complex code into **easy-to-understand insights**
- Helps students understand:
  - Logic flow  
  - Algorithm working  
  - Optimization suggestions  

---

### 🔹 2. Fine-Tuned LLM (Code LLaMA 7B)
- Specialized for **code understanding tasks**
- Fine-tuned on a curated dataset of:
  - Java programs  
  - Data structures & algorithms  
- Performs:
  - ✅ Time Complexity Analysis  
  - ✅ Space Complexity Analysis  
  - ✅ Code Structure Evaluation  
  - ✅ Pattern Recognition  

---

### 🔹 3. Hybrid Output Merger
- Combines outputs from both AI models
- Produces:
  - Structured JSON output  
  - Clear explanation + technical evaluation  
- Ensures:
  - Accuracy (LLM) + Readability (Generative AI)

---

---

## 🔥 Key Features

- 🔍 Intelligent Code Analysis  
- ⚡ Time & Space Complexity Detection  
- 📊 Code Quality Evaluation  
- 💡 AI-Based Suggestions for Optimization  
- 📘 Educational Explanation Generation  
- 🔗 Hybrid AI Integration (Gemini + CodeLLaMA)  

---

## 🛠️ Tech Stack

- **Backend:** FastAPI  
- **AI Models:**  
  - Gemini API (Generative AI)  
  - Fine-Tuned Code LLaMA 7B  
- **Languages:** Python, Java  
- **Dataset:** Custom curated Java code dataset  
- **Tools:** PyTorch / Transformers, JSON Processing  

---

## 🔐 Security & Best Practices

- API keys managed using **environment variables (.env)**  
- `.gitignore` used to prevent sensitive data leaks  
- Modular architecture for scalability  

---

## 📦 Project Structure
app/

├── api/

│ └── routes.py

├── services/

│ ├── gemini_service.py

│ └── codellama_service.py

├── core/

│ ├── merger.py

│ └── prompt_builder.py

├── schemas/

│ └── request.py

└── utils/


main.py

requirements.txt



---

## 🚀 How It Works

1. User submits code  
2. API receives request via FastAPI  
3. Code is sent to:
   - Gemini → Explanation  
   - Code LLaMA → Analysis  
4. Outputs are merged  
5. Final structured response returned  

---

## 🎯 Use Case

- 👨‍🎓 Students learning programming  
- 🏫 Educational institutions  
- 💻 Coding practice platforms  
- 📊 Code evaluation systems  

---

## 🧪 Future Enhancements

- Multi-language support (C++, Python, etc.)  
- Real-time code feedback  
- Integration with online judges  
- AI-based plagiarism detection  
- Performance benchmarking  

---

## 🏆 Innovation Highlights

- Hybrid AI Architecture  
- Educational-focused explainability  
- Fine-tuned domain-specific LLM  
- Combines **accuracy + interpretability**  

---

## 📄 License

This project is developed for educational and research purposes.

---

## ⭐ Final Pitch Line

> “Code Insight bridges the gap between code execution and code understanding by combining generative intelligence with fine-tuned analytical models.”
