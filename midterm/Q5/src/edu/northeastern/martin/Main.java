package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] arr = {0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11};
        int [] values = {1,4,5,10};
        int [] output = getStartOfEachValues(arr, values);
        System.out.println("put break point here to see output");
    }

    //Time O(m + n)   m,n = legnth of arr, values;
    //Spacce O(n)    n = length of values;
    public static int[] getStartOfEachValues(int[] arr, int[] values){

        Map<Integer, Integer> map = new HashMap<>();
        int[] indexes = new int[values.length];

        //O(m)
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = -1;
            map.put(values[i], i);
        }

        //O(n)
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if(map.containsKey(value) && indexes[map.get(value)] == -1){
                indexes[map.get(value)] = i;
            }
        }
        return indexes;
    }

}
