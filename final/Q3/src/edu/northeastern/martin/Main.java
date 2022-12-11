package edu.northeastern.martin;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String input1 = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(input1));

        String input2 = "a)b(c)d";
        System.out.println(minRemoveToMakeValid(input2));

        String input3 = "))((";
        System.out.println(minRemoveToMakeValid(input3));
    }

    // Space complexity O(n)
    // Time complexity O(n)
    public static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '('){
                stack.push(i);
            }else if(sb.charAt(i) == ')' && !stack.isEmpty()){
                stack.pop();
            }else if(sb.charAt(i) == ')' && stack.isEmpty()){
                //No ( to cover, WRONG!, delete it
                sb.deleteCharAt(i);
                i--;
            }
        }

        //delete remaining (
        while(!stack.isEmpty()){
            sb.deleteCharAt(stack.pop());
        }

        return sb.toString();
    }
}
