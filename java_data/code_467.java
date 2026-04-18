package zhang.algorithm.leetcode.question98_Validate_BST;

import zhang.algorithm.modelUtil.Tree.TreeNode;


public class ValidateBST {
    
    private TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)) return false;
        if(prev != null && root.val <= prev.val) return false;
        prev = root;

        return isValidBST(root.right);
    }


    public static void main(String[] args) {
        ValidateBST test = new ValidateBST();
        TreeNode root = new TreeNode(10);
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(15);
        root.left = a;
        root.right = b;
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(20);
        test.isValidBST(root);
    }
}