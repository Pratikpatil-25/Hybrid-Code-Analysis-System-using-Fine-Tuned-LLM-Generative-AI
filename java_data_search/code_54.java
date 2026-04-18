class TreeNode {

    int data;

    TreeNode left, right;



    public TreeNode(int data) {

        this.data = data;

        this.left = this.right = null;

    }

}



public class bst {

    private TreeNode root;



    public void insert(int key) {

        root = insertRecursive(root, key);

    }



    private TreeNode insertRecursive(TreeNode root, int key) {

        if (root == null) {

            return new TreeNode(key);

        }



        if (key < root.data) {

            root.left = insertRecursive(root.left, key);

        } else if (key > root.data) {

            root.right = insertRecursive(root.right, key);

        }



        return root;

    }



    public boolean search(int key) {

        return searchRecursive(root, key);

    }



    private boolean searchRecursive(TreeNode root, int key) {

        if (root == null || root.data == key) {

            return root != null;

        }



        if (key < root.data) {

            return searchRecursive(root.left, key);

        } else {

            return searchRecursive(root.right, key);

        }

    }



    public void inorderTraversal() {

        inorderTraversalRecursive(root);

    }



    private void inorderTraversalRecursive(TreeNode root) {

        if (root != null) {

            inorderTraversalRecursive(root.left);

            System.out.print(root.data + " ");

            inorderTraversalRecursive(root.right);

        }

    }



    public static void main(String[] args) {

        bst bst = new bst();



        bst.insert(50);

        bst.insert(30);

        bst.insert(20);

        bst.insert(40);

        bst.insert(70);

        bst.insert(60);

        bst.insert(80);



        System.out.println("Inorder Traversal:");

        bst.inorderTraversal();



        int keyToSearch = 40;

        System.out.println("\nSearch for key " + keyToSearch + ": " + bst.search(keyToSearch));

    }

}