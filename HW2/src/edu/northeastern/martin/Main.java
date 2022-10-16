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

        // Q6 Test
        TreeNode q6 = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2,null, new TreeNode(9)));
        System.out.println(widthOfBinaryTree(q6));

        // Q7 Test
        TreeNode q7 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(lowestCommonAncestor(q7, q7.left, q7.right).val);

        //Q8 Test
        TreeNode q8 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(findLeaves(q8));

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

    //Q6
    public static int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root,0);
        queue.add(root);
        int res =0;
        while(!queue.isEmpty()){
            int n = queue.size();
            int start = 0;
            int end = 0;
            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                int index = map.get(node);
                if(i == 0){
                    start = index;
                }
                if(i == n-1){
                    end = index;
                }
                if(node.left!= null){
                    queue.add(node.left);
                    map.put(node.left,index*2);
                }
                if(node.right != null){
                    queue.add(node.right);
                    map.put(node.right,index*2+1);
                }
            }
            res = Math.max(res,end-start+1);
        }
        return res;
    }

    // Q7
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(dfsFoundKid(p,q)){
            return p;
        }

        if(dfsFoundKid(q,p)){
            return q;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean foundP= false;
        boolean foundQ = false;
        Map<TreeNode,TreeNode> map = new HashMap<>();
        while(!queue.isEmpty() && !(foundP && foundQ)){

            TreeNode temp = queue.poll();
            if(temp == p){
                foundP = true;
            }
            if(temp == q){
                foundQ = true;
            }
            if(temp.left != null){
                map.put(temp.left,temp);
                queue.add(temp.left);
            }
            if(temp.right != null){
                map.put(temp.right,temp);
                queue.add(temp.right);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        boolean foundParent = false;
        set.add(p);
        set.add(q);
        TreeNode pCur = p;
        TreeNode qCur = q;
        while(!foundParent){
            TreeNode tempP  = map.get(pCur);
            if(tempP != null && !set.add(tempP)){
                return tempP;
            }
            TreeNode tempQ  = map.get(qCur);
            if(tempQ != null && !set.add(tempQ)){
                return tempQ;
            }
            pCur = tempP;
            qCur = tempQ;

        }
        return null;
    }
    private static boolean dfsFoundKid(TreeNode p, TreeNode q) {
        if(p == null){
            return false;
        }

        if (p == q) {
            return true;
        }

        return dfsFoundKid(p.left,q) || dfsFoundKid(p.right,q);
    }

    // Q8

    static List<List<Integer>> output = new ArrayList();
    static List<Integer> [] array = new ArrayList[100];
    public static List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        for(int i = 0; i < 100;i++){
            if(array[i]!= null)
                output.add(array[i]);
        }
        return output;
    }

    public static int dfs(TreeNode node){
        if(node == null){
            return 0;
        }else if(node.left == null && node.right == null){
            if(array[0] == null){
                array[0] = new ArrayList<Integer>();
            }
            array[0].add(node.val);
            return 0;
        }else{
            int level =  1 + Math.max(dfs(node.left),dfs(node.right));
            if(array[level] == null){
                array[level] = new ArrayList<Integer>();
            }
            array[level].add(node.val);
            return level;
        }
    }
}
