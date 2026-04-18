package com.tgt.igniteplus;
public class Node
{
    public static void main(String[] args) throws Exception
    {         TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode G = new TreeNode("G");
        TreeNode K = new TreeNode("K");
        TreeNode C = new TreeNode("C", D, null);
        TreeNode H = new TreeNode("H", K, null);
        TreeNode B = new TreeNode("B", C, E);
        TreeNode F = new TreeNode("F", G, H);
        TreeNode root = new TreeNode("A", B, F);
        System.out.println("All Leaf Nodes of the tree are:\n");
        printLeaves(root);
    }
    private static class TreeNode
    {
        String value;
        TreeNode left;
        TreeNode right;

    TreeNode(String value)
    {
        this.value = value;
    }

    TreeNode(String data, TreeNode left, TreeNode right) {
        this.value = data;
        this.left = left;
        this.right = right;
    }

    boolean isLeaf() {
        return left == null ? right == null : false;
    }
}
    
    public static void printLeaves(TreeNode node)
    {
                if (node == null)
        {
            return;
        }
        if (node.isLeaf())
        {
            System.out.printf("%s ", node.value);
        }
        printLeaves(node.left); printLeaves(node.right);
    }
}