import java.util.Scanner;

class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    BSTNode(int data) {
        this.data = data;
    }
}

class BSTOperations {
    BSTNode root; 
    BSTNode insert(int data, BSTNode currrentNode) {
        if (currrentNode == null) {
            currrentNode = new BSTNode(data);
            return currrentNode;
        }
                if (data < currrentNode.data) {
            currrentNode.left = insert(data, currrentNode.left);
        } else if (data > currrentNode.data) {
            currrentNode.right = insert(data, currrentNode.right);
        }
        return currrentNode;

            }

    void search(int data) {
        String result = search(root, data) ? "Found" : "Not Found";
        System.out.println(result);
    }

        int min(BSTNode root) {
        int minVal = root.data;
        while (root.left != null) {
            minVal = root.data;
            root = root.left;
        }
        return minVal;
    }

    int minRec(BSTNode root) {
        if (root.left == null) {
            return root.data;
        }
        return minRec(root.left);
    }

        int max(BSTNode root) {
        int maxElement = root.data;
        while (root.right != null) {
            maxElement = root.data;
            root = root.right;
        }
        return maxElement;
    }

    int maxRec(BSTNode root) {
        if (root.right == null) {
            return root.data;
        }
        return maxRec(root.right);
    }

    boolean search(BSTNode currentNode, int data) {
        if (currentNode == null) {
            return false;
        }
        if (currentNode.data == data) {
            return true;
        }
        if (currentNode.data > data) {
                        return search(currentNode.left, data);
        } else {
            return search(currentNode.right, data);
        }
    }

    void insert(int data) {
        root = insert(data, root);
    }

    void print() {
                System.out.println("InOrder....");
        print(root);

    }

    void print(BSTNode node) {
        if (node != null) {
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }

    void delete(BSTNode currentNode, BSTNode parentNode, boolean isLeft, int data) {
                if (data > currentNode.data) {
            delete(currentNode.right, currentNode, false, data);
        } else if (data < currentNode.data) {
            delete(currentNode.left, currentNode, true, data);
        } else {
            
                        if (currentNode.left == null && currentNode.right == null) {
                if (isLeft) {
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            } else
                        if (currentNode.left == null && currentNode.right != null) {
                if (isLeft) {
                    parentNode.left = currentNode.right;
                } else {
                    parentNode.right = currentNode.right;
                }
            } else
                        if (currentNode.left != null && currentNode.right == null) {
                if (isLeft) {
                    parentNode.left = currentNode.left;
                } else {
                    parentNode.right = currentNode.left;
                }
            } else
                        if (currentNode.left != null && currentNode.right != null) {
                                BSTNode temp = currentNode;
                int leftMax = this.max(temp.left);                 currentNode.data = leftMax;
                delete(temp.left, currentNode, true, leftMax);
            }
        }
    }

}

public class BST {
    public static void main(String[] args) {
        BSTOperations opr = new BSTOperations();
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Insert in Tree");
            System.out.println("2. Print");
            System.out.println("3. Delete");
            System.out.println("4. Exit");
            System.out.println("Enter the Choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("Enter the Data enter -1 to exit ");
                        int data = scanner.nextInt();
                        if (data == -1) {
                            break;
                        }
                        opr.insert(data);
                    }
                    break;
                case 2:
                    opr.print();
                    break;
                case 4:
                    return;
            }
        }
    }
}