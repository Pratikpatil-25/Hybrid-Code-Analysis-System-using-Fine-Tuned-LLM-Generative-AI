public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left,val);
        }else{
            root.right = insert(root.right,val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root==null){
            return false;
        }
        if(root.data>key){
            return search(root.left,key);
        }
        else if(root.data==key){
            return true;
        }else{
            return search(root.right,key);
        }
    }


    public static Node delete(Node root,int val){
        if(root.data>val){
            root.left = delete(root.left, val);
        }
        else if(root.data<val){
            root.right = delete(root.right, val);
        }

        else{
            if(root.left == null && root.right ==null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right,IS.data);

        }
        return root;
    }
    public static Node inorderSuccessor(Node root){
        while(root.left!=null){
            root = root.left;
                }
                return root;
    }

    public static void print(Node root,int x,int y){
        if(root==null){
            return;
        }
        if(root.data>=x && root.data<=y){
            print(root.left, x, y);
            System.out.print(root.data+" ");
            print(root.right, x, y);
        }
        else if(root.data>=y){
            print(root.left, x, y);
        }else{
            print(root.right, x, y);
        }
    }

    public static void main(String[] args) {
    int[] arr = {5,1,3,4,2,7};
    Node root = null;

        for(int i=0;i<arr.length;i++){
            root = insert(root, arr[i]);
        }
         inorder(root);
         System.out.println();

        
                        print(root, 1, 9);
    }
}