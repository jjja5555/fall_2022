package edu.northeastern.martin;

public class Solution3 {
    private long last = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    private boolean helper(TreeNode root){
        if(root == null){
            return true;
        }
        if(!helper(root.left)){
            return false;
        }
        if(root.val <= last){
            return false;
        }
        last = root.val;
        if(!helper(root.right)){
            return false;
        }
        return true;
    }
}
