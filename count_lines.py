import os

# 1. Configuration
folders = [
    "java_data", 
    "java_data_sort", 
    "java_data_search", 
    "java_data_recursion"
]

MAX_LINES = 200
files_removed = 0
files_kept = 0

def count_lines(filepath):
    """Counts the number of lines in a file efficiently."""
    try:
        with open(filepath, 'r', encoding='utf-8', errors='ignore') as f:
            return sum(1 for line in f)
    except Exception as e:
        print(f"Error reading {filepath}: {e}")
        return None

# 2. Main Loop
for folder in folders:
    if not os.path.exists(folder):
        print(f"Folder not found: {folder}")
        continue

    print(f"Filtering folder: {folder}...")
    
    for filename in os.listdir(folder):
        if filename.endswith(".java"):
            file_path = os.path.join(folder, filename)
            line_count = count_lines(file_path)

            if line_count is not None:
                if line_count >= MAX_LINES:
                    # Remove the file if it meets or exceeds the limit
                    os.remove(file_path)
                    files_removed += 1
                else:
                    files_kept += 1

# 3. Summary
print("-" * 30)
print(f"Filtering Complete!")
print(f"Files kept: {files_kept}")
print(f"Files deleted (>= 200 lines): {files_removed}")