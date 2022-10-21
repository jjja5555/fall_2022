package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Q1 Test
        int [] candidates = new int[]{2,3,5};
        List<List<Integer>> result = combinationSum(candidates, 8);
        System.out.println(result);

        // Q2 Test
        int [] nums = new int[]{1,2,3};
        List<List<Integer>> q2Output = permute(nums);
        System.out.println(q2Output);

        // Q3 Test
        System.out.println(letterCombinations("23"));

        // Q4 Test
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,"ABCCED"));

        // Q5 Test
        int [] q5out = numsSameConsecDiff(3,7);
        System.out.println(q5output);

        // Q6 Test
        System.out.println(subsets(new int[]{1,2,3}));

        // Q7 Test
        System.out.println(generateParenthesis(3));
    }

    // Q1
    static Deque<Integer> temp = new ArrayDeque<>();
    static List<List<Integer>> output = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumHelper(candidates, target, 0);
        return output;
    }

    public static void combinationSumHelper(int[] candidates, int target, int i){
        if(target < 0){
            return;
        }else if(target == 0){
            output.add(new ArrayList<>(temp));
        }else{
            for (int j = i; j < candidates.length; j++) {
                temp.push(candidates[j]);
                combinationSumHelper(candidates, target - candidates[j], j);
                temp.pop();
            }
        }
    }

    // Q2
    static List<List<Integer>> q2Output = new ArrayList<>();
    static List<Integer> q2Temp = new ArrayList<>();;
    static boolean [] q2Visited;
    public static List<List<Integer>> permute(int[] nums) {
        q2Visited = new boolean[nums.length];
        permuteHelper(nums);
        return q2Output;
    }

    public static void permuteHelper(int[] nums) {
        if(q2Temp.size() == nums.length){
            q2Output.add(new ArrayList<>(q2Temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!q2Visited[i]){
                q2Visited[i] = true;
                q2Temp.add(num);
                permuteHelper(nums);
                q2Visited[i] = false;
                q2Temp.remove(q2Temp.size()-1);
            }
        }
    }


    //Q3
    public static List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if(digits.length() == 0)return res;
        map.put('2',"abc");
        map.put('3',"edf");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        dfs(map,res,digits,0, new StringBuilder());
        return res;
    }

    private static void dfs(Map<Character, String> map, List<String> res, String digits, int i,StringBuilder sb) {
        if(i == digits.length()){
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(i);
        char []chars = map.get(c).toCharArray();
        for (char aChar : chars) {
            sb.append(aChar);
            dfs(map,res,digits,i+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    //Q4

    static boolean [][] visited;
    static int m;
    static int n;
    public static boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean [m][n];
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != word.charAt(0)){
                    continue;
                }
                if(backTrace(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backTrace(char[][] board, String word, int i, int j, int index){
        if( i < 0 || i >= m || j < 0 || j >= n ||
                visited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }

        if(index == word.length()-1){
            return true;
        }
        visited[i][j] = true;
        boolean output =    backTrace(board, word, i-1, j, index+1) ||
                backTrace(board, word, i+1, j, index+1) ||
                backTrace(board, word, i, j-1, index+1) ||
                backTrace(board, word, i, j+1, index+1);
        visited[i][j] = false;
        return output;
    }

    //Q5
    static List<Integer> q5output = new ArrayList();
    public static int[] numsSameConsecDiff(int n, int k) {
        for(int i = 1; i < 10; i++){
            numsSameConsecDiffHelper(n-1,k,i,i);
        }
        int[] array = new int [q5output.size()];
        for(int i = 0; i < q5output.size(); i++){
            array[i] = q5output.get(i);
        }
        return array;
    }

    public static void numsSameConsecDiffHelper(int n, int k, int result, int lastDigit) {
        if(n == 0){
            q5output.add(result);
            return;
        }
        if(lastDigit + k <10 ){
            int curDigit = lastDigit + k;
            numsSameConsecDiffHelper(n-1, k, result*10+curDigit, curDigit);
        }

        if(k != 0 && lastDigit - k >=0){
            int curDigit = lastDigit - k;
            numsSameConsecDiffHelper(n-1, k, result*10+curDigit, curDigit);
        }
    }

    //Q6
    static List<Integer> list = new ArrayList();
    static List<List<Integer>> q6output = new ArrayList();
    public static List<List<Integer>> subsets(int[] nums) {
        recursion(nums, 0);
        return q6output;
    }

    public static void recursion(int[] nums, int index){
        if(index == nums.length){
            q6output.add(new ArrayList(list));
            return;
        }
        list.add(nums[index]);
        recursion(nums, index+1);
        list.remove(list.size()-1);
        recursion(nums, index+1);
    }


    // Q7
    static List<String> q7output = new ArrayList();
    public static List<String> generateParenthesis(int n) {
        recursion("", n, n);
        return q7output;
    }

    private static void recursion (String str, int n, int m){
        if(n == 0 && m == 0){
            q7output.add(str);
            return;
        }
        if(n>=0)
            recursion(str+'(',n-1,m);
        if(m>=0 && m>n)
            recursion(str+')',n, m-1);
    }
}
