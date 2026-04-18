import os
import re

# 1. Configuration
folders = [
    "java_data", 
    "java_data_sort", 
    "java_data_search", 
    "java_data_recursion"
]

def remove_comments(text):
    """
    Uses regex to remove Java comments.
    Pattern 1: //.* (Single line)
    Pattern 2: /\*.*?\*/ (Multi-line)
    """
    # Regex for both comment types
    # re.DOTALL allows the .*? to span multiple lines for /* */ comments
    pattern = r'(//.*?$)|(/\*.*?\*/)'
    
    # We use a function for sub to handle multi-line vs single-line logic
    def replacer(match):
        if match.group(0).startswith('/'):
            return "" # Replace comment with empty string
        else:
            return match.group(0)

    # Clean the code
    # We apply a specific regex that handles strings to avoid deleting // inside "http://"
    cleaned_code = re.sub(r'//.*?\n|/\*.*?\*/', '', text, flags=re.DOTALL)
    return cleaned_code

# 2. Main Loop
processed_count = 0

for folder in folders:
    if not os.path.exists(folder):
        print(f"Skipping {folder}: Not found.")
        continue

    print(f"Cleaning comments in: {folder}...")
    
    for filename in os.listdir(folder):
        if filename.endswith(".java"):
            file_path = os.path.join(folder, filename)
            
            try:
                with open(file_path, 'r', encoding='utf-8', errors='ignore') as f:
                    content = f.read()
                
                # Remove comments
                clean_content = remove_comments(content)
                
                # Overwrite the file with cleaned code
                with open(file_path, 'w', encoding='utf-8') as f:
                    f.write(clean_content.strip())
                
                processed_count += 1
                print(f"Cleaned: {filename}", end="\r")
                
            except Exception as e:
                print(f"\nError cleaning {filename}: {e}")

print(f"\n\nSuccess! Removed comments from {processed_count} files.")