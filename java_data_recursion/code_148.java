package com.muthukumarasamym.recursion;

class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTreeTraversal {
	Node root;

	BinaryTreeTraversal() {
		root = null;
	}

	public void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);

		System.out.print(node.data + " ");

		inorder(node.right);
	}

	public void preOrder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");

	}

	public static void main(String[] args) {

		BinaryTreeTraversal tree = new BinaryTreeTraversal();
		tree.root = new Node(4);
		tree.root.left = new Node(5);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(1);
		tree.root.right.left = new Node(9);
		tree.root.right.right = new Node(10);

		System.out.println("inorder ");
		tree.inorder(tree.root);
		System.out.println("\nPreorder ");
		tree.preOrder(tree.root);
		System.out.println("\nPostOrder");
		tree.postOrder(tree.root);

	}

}