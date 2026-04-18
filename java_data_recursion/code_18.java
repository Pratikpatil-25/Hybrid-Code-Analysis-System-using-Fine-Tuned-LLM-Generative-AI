import java.util.*;

public class Temp2 {
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
        Node val=new Node(data);
        if(root==null){
            root=val;
        }else{
            if(data<root.data){
                root.left=recursion(root.left,data);
            }
            if(data>root.data){
                root.right=recursion(root.right,data);
            }
        }
        return root;
    }
    public static Node invert(Node root){
        if(root==null){
            return null;
        }
        Node left=invert(root.left);
        Node right=invert(root.right);

        root.left=right;
        root.right=left;

        return root;
    }
    public static void print(Node root){
        if(root==null){
            return;
        }
        print(root.left);
        System.out.print(root.data);
        print(root.right);
    }
    public static void main(String[] args) {
        System.out.print("Enter number of nodes:- ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print("Enter nodes:- ");
        for(int i=0;i<n;i++){
            int num=sc.nextInt();
            insert(num);
        }
        invert(root);
        print(root);
    }
}