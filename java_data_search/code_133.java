class BinarySearchTree {
	static class Node {
		int value;
		Node left, right;

		Node(int value) {
			this.value = value;
			left = right = null;
		}
	}

	Node root;

	public void insert(int value) {
		root = insertRec(root, value);
	}

	private Node insertRec(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}
		if (value < root.value) {
			root.left = insertRec(root.left, value);
		} else if (value > root.value) {
			root.right = insertRec(root.right, value);
		}
		return root;
	}

	public boolean search(int value) {
		return searchRec(root, value);
	}

	private boolean searchRec(Node root, int value) {
		if (root == null) {
			return false;
		}
		if (root.value == value) {
			return true;
		}
		return value < root.value ? searchRec(root.left, value) : searchRec(root.right, value);
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(70);
		tree.insert(20);
		tree.insert(40);

		System.out.println("Is 40 present? " + tree.search(40));
		System.out.println("Is 25 present? " + tree.search(25));
	}
}