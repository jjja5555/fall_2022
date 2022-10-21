package edu.northeastern.martin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] candidates = new int[]{2,3,5};
        List<List<Integer>> result = combinationSum(candidates, 8);
        System.out.println(result);
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
    public static List<List<Integer>> permute(int[] nums) {
        output = new ArrayList<>();
        temp = new ArrayDeque<>();
        permuteHelper(nums, 0);
        return output;
    }

    static boolean [] set = new boolean[20];
    public static void permuteHelper(int[] nums, int i) {
        for (int j = 0; j < nums.length; j++) {
            if(set[nums[i]]){
                continue;
            }
            set[nums[i]] = true;
            permuteHelper(nums, i+1);
            set[nums[i]] = false;
        }
    }
}
