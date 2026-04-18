import json

with open("final_dataset.json", "r") as file:
    data = json.load(file)

print(len(data))