def build_prompt(user_code: str) -> str:
    """
    Simulates fine-tuning using:
    - Structured prompt
    - Few-shot learning
    - Output conditioning
    """

    prompt = f"""
You are an expert Java code analyzer.

Analyze the given code and strictly follow the format.

### Instructions:
1. Identify Time Complexity (Big-O)
2. Identify Space Complexity
3. Explain step-by-step
4. Suggest optimization

### Few-shot Examples:

Example 1:
Code:
for(int i=0; i<n; i++) {{
    System.out.println(i);
}}

Output:
Time Complexity: O(n)
Space Complexity: O(1)
Explanation: Single loop runs n times
Optimization: Already optimal

---

Example 2:
Code:
for(int i=0; i<n; i++) {{
    for(int j=0; j<n; j++) {{
        System.out.println(i + j);
    }}
}}

Output:
Time Complexity: O(n^2)
Space Complexity: O(1)
Explanation: Nested loops
Optimization: Consider better algorithm

---

### Now analyze:

Code:
{user_code}

### Output Format (STRICT):
Time Complexity:
Space Complexity:
Explanation:
Optimization:
"""
    return prompt