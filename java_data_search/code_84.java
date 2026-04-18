import java.util.*;

public class y {

    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = null;
            right = null;
        }
    }

    Node root;

    y() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null || root.key == key) {
            return root != null;
        }

        if (root.key < key) {
            return searchRec(root.right, key);
        }

        return searchRec(root.left, key);
    }

        int findIndex(int key) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrderToList(root, inOrderList);
        return inOrderList.indexOf(key);
    }

        void inOrderToList(Node node, List<Integer> list) {
        if (node != null) {
            inOrderToList(node.left, list);
            list.add(node.key);
            inOrderToList(node.right, list);
        }
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        y tree = new y();

                tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

                System.out.println("In-order traversal:");
        tree.inorder();

                System.out.println("\n\nSearch for 40: " + tree.search(40));
        System.out.println("Search for 90: " + tree.search(90));

                System.out.println("\nIndex of 40: " + tree.findIndex(40));
        System.out.println("Index of 60: " + tree.findIndex(60));
        System.out.println("Index of 80: " + tree.findIndex(80));
    }
}