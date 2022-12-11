package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String [] input1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(findAnagram(input1));

        String [] input2 = {""};
        System.out.println(findAnagram(input2));

        String [] input3 = {"a"};
        System.out.println(findAnagram(input3));
    }

    // Space complexity O(n), n = input.length
    // Time complexity O(n), n = input.length
    public static List<List<String>> findAnagram(String[] input){
        // Additional map to store
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> output = new ArrayList<>();
        for(String s : input){
            char [] array = s.toCharArray();
            Arrays.sort(array);
            String key = "";
            for(char c : array){
                key+= c;
            }
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        for(String key : map.keySet()){
            output.add(map.get(key));
        }

        return output;
    }
}
