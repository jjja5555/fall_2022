package edu.northeastern.martin;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	    // Q1 Test
        TreeNode q1 = new TreeNode(1,new TreeNode(2,new TreeNode(3), new TreeNode(4)), new TreeNode(2,new TreeNode(4), new TreeNode(3)));
        System.out.println(isSymmetric(q1));

        // Q2 Test
        TreeNode q2 = new TreeNode(3, new TreeNode(9), new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(maxDepth(q2));

        // Q3 Test
        TreeNode q3 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        System.out.println(rightSideView(q3));

        // Q4 Test
        TreeNode q4 = new TreeNode(3, new TreeNode(9), new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(zigzagLevelOrder(q4));

        // Q5 Test
        TreeNode q5 = new TreeNode(3, new TreeNode(9), new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(verticalOrder(q5));
    }

    //Q1
    public static boolean isSymmetric(TreeNode root) {
        return isSymmetricRecursion(root.left,root.right);
    }
    private static boolean isSymmetricRecursion(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return isSymmetricRecursion(left.right,right.left) && isSymmetricRecursion(right.right,left.left);
    }

    //Q2
    public static int maxDepth(TreeNode root) {
        return maxDepthRecursion(root,1);
    }

    private static int maxDepthRecursion(TreeNode root, int depth) {
        if(root == null){
            return 0;
        }
        int left = maxDepthRecursion(root.left,depth+1);
        int right = maxDepthRecursion(root.right,depth+1);
        return  left > right ? 1 + left : 1 + right;
    }

    //Q3
    //private static List<Integer> output = new ArrayList<>();

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        rightTraversal(root,1, output);
        return output;
    }

    private static void rightTraversal(TreeNode root,int depth, List<Integer> output){
        if(root == null){
            return;
        }
        if(depth > output.size()){
            output.add(root.val);
        }

        rightTraversal(root.right, depth+1, output);
        rightTraversal(root.left, depth+1, output);
    }

    //Q4

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new LinkedList<>();
        travelLeft(root,0, output);
        for(int i = 0; i < output.size(); i++){
            if(i%2 == 1){
                Collections.reverse(output.get(i));
            }
        }
        return output;
    }

    public static void travelLeft(TreeNode root,int depth, List<List<Integer>> output){
        if(root == null){
            return;
        }
        if(depth == output.size()){
            output.add(new ArrayList<Integer>());
        }
        output.get(depth).add(root.val);
        travelLeft(root.left,depth+1, output);
        travelLeft(root.right,depth+1, output);
    }

    //Q5

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> indexQ = new LinkedList<>();
        List<Integer>[] al = new ArrayList[200];
        if(root == null)
            return output;
        nodeQ.add(root);
        indexQ.add(100);
        int maxI = 100;
        int minI = 100;
        while(!nodeQ.isEmpty()){
            TreeNode temp = nodeQ.poll();
            Integer i = indexQ.poll();
            if(i < minI){
                minI = i;
            }
            if(i > maxI){
                maxI = i;
            }
            if(al[i] == null){
                al[i] = new ArrayList<Integer>();
            }
            al[i].add(temp.val);
            if(temp.left != null){
                nodeQ.add(temp.left);
                indexQ.add(i-1);
            }
            if(temp.right != null){
                nodeQ.add(temp.right);
                indexQ.add(i+1);
            }
        }
        for(int i = minI; i <= maxI; i++){
            output.add(al[i]);
        }
        return output;
    }
}
