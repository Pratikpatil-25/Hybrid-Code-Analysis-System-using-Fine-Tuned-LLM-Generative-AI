class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

        BinarySearchTree() {
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
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;     }

        boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null) return false;
        if (root.key == key) return true;

        return key < root.key
            ? searchRec(root.left, key)
            : searchRec(root.right, key);
    }

        void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
                        if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

                        root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minVal = root.key;
        while (root.left != null) {
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
    }

        void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
        System.out.println();
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
        System.out.println();
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

        public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

                bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder traversal:");
        bst.inorder();

        System.out.println("Preorder traversal:");
        bst.preorder();

        System.out.println("Postorder traversal:");
        bst.postorder();

                System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 90: " + bst.search(90));

                System.out.println("\nDeleting 20");
        bst.deleteKey(20);
        bst.inorder();

        System.out.println("Deleting 30");
        bst.deleteKey(30);
        bst.inorder();

        System.out.println("Deleting 50");
        bst.deleteKey(50);
        bst.inorder();
    }
}