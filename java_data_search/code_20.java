class Trie {
	class TrieNode {
		char data;
		private boolean endOfWord;
		private TrieNode[] childrens;

		public TrieNode(char data) {
			this.data = data;
			endOfWord = false;
			childrens = new TrieNode[26];
		}

		public TrieNode() {
			childrens = new TrieNode[26];
		}
	}

	private TrieNode root;
    public Trie() {
    root = new TrieNode();
	}

	public void insert(String word) {
		if (word == null || word.isEmpty())
			return;
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (curr.childrens[index] == null) {
				curr.childrens[index] = new TrieNode(c);
			}
			curr = curr.childrens[index];
		}
		curr.endOfWord = true;
	}

	public boolean search(String word) {
		if (word == null || word.isEmpty())
			return false;
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (curr.childrens[index] == null) {
				return false;
			}
			curr = curr.childrens[index];
		}
		return curr.endOfWord;
	}

	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.isEmpty())
			return false;
		TrieNode curr = root;
		for (char c : prefix.toCharArray()) {
			int index = c - 'a';
			if (curr.childrens[index] == null) {
				return false;
			}
			curr = curr.childrens[index];
		}
		return curr != null;

	}
}