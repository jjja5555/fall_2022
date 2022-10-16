package edu.northeastern.martin;

import com.sun.jdi.IntegerValue;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value, TreeNode left, TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
    TreeNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] array = new int[]{1,2,3,4,5,6,7};
        rotateArrayK(array,3);
        System.out.println();
        TreeNode a = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode b = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        boolean result = checkTreeNode(a,b);
        System.out.println(result);
    }


    public static void rotateArrayK(int [] nums, int k){
        for (int i = 0; i < k; i++) {
            int n = nums[nums.length-1];
            int last = nums[0];
            for (int j = 1; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = last;
                last = temp;
            }
            nums[0] = n;
        }
    }

    public static boolean checkTreeNode(TreeNode a, TreeNode b){
        return checkHelper(a,b);
    }

    public static boolean checkHelper(TreeNode a, TreeNode b){
        if(a!= null && b != null){
            return  (a.value == b.value) && checkHelper(a.left,b.left) && checkHelper(a.right, b.right);
        }else if(a == null && b == null){
            return true;
        }else{
            return false;
        }
    }
}
