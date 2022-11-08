package edu.northeastern.martin;

public class Solution4 {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        helper(root);
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    public void helper(TreeNode root) {
        if(root == null){
            return;
        }
        helper(root.left);
        if(pre.val > root.val){
            second = root;
            if(first == null){
                first = pre;
            }
        }
        pre = root;
        helper(root.right);
    }
}
