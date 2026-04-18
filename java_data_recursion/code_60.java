import java.util.*;

public class Temp4 {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static Node root=null;
    public static void insert(int data){
        root=recursion(root,data);
    }
    public static Node recursion(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        if(data<root.data){
            root.left=recursion(root.left,data);
        }
        if(data>root.data){
            root.right=recursion(root.right,data);
        }
        return root;
    }
    public static boolean subtree(Node root1,Node root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.data==root2.data){
            if(checksame(root1,root2)){
                return true;
            }
        }
        return subtree(root1.left,root2.left)||subtree(root1.right,root2.right);
    }
    public static boolean checksame(Node root1,Node root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        if(root1.data!=root2.data){
            return false;
        }
        return checksame(root1.left,root2)&&checksame(root1.right,root2);
    }
    public static void main(String[] args) {

        Node root1 = null;
        root1 = recursion(root1, 4);
        root1 = recursion(root1, 2);
        root1 = recursion(root1, 6);
        root1 = recursion(root1, 1);
        root1 = recursion(root1, 3);

        Node root2 = null;
        root2 = recursion(root2, 2);
        root2 = recursion(root2, 1);
        root2 = recursion(root2, 3);

        boolean ans = subtree(root1, root2);
        System.out.println(ans);
    }
}