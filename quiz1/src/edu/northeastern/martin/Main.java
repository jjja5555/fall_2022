package edu.northeastern.martin;

import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    //q3 DFS global result for output
    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> dfsResult = new ArrayList<>();
        dfs(root, 0, dfsResult);
        return dfsResult;
    }

    public static void dfs(TreeNode root, int level, List<List<Integer>> dfsResult){
        if(root == null){
            return;
        }
        if(level == dfsResult.size()){
            dfsResult.add(new ArrayList<>());
        }
        dfsResult.get(level).add(root.value);
        dfs(root.left, level + 1, dfsResult);
        dfs(root.right, level + 1, dfsResult);
    }

    // q3 BFS
    public static List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> bfsResult = new ArrayList<>();
        if(root == null){
            return bfsResult;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> currentLevelList = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = queue.poll();
                currentLevelList.add(temp.value);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            bfsResult.add(currentLevelList);
        }
        return bfsResult;
    }
}
