package edu.northeastern.martin;

import java.util.ArrayList;

public class MaxMinHeap {
    int [] arrList = new int[1000];
    int current = -1;
    boolean isMinHeap;

    public MaxMinHeap(){
    }

    private int parent(int n){
        return (n-1)/2;
    }

    private int leftChild(int n){
        return 2*n+1;
    }

    private int rightChild(int n){
        return 2*n+2;
    }

    public int peek(){
        if(current <0){
            return Integer.MIN_VALUE;
        }
        return arrList[0];
    }

    public void add(int value){
        arrList[++current] = value;
        shiftUp(current);
    }

    private void shiftUp(int index){
        if(index==0){
            return;
        }
        int parent = parent(index);
        if(arrList[parent] < arrList[index]){
            return;
        }
        int temp = arrList[parent];
        arrList[parent] = arrList[index];
        arrList[index] = temp;
        shiftUp(parent);
    }

    public int remove(){
        if(current < 0){
            return Integer.MIN_VALUE;
        }

        int minValue = arrList[0];

        arrList[0] = arrList[current--];
        shiftDown(0);
        return minValue;
    }

    private void shiftDown(int index){
        if(index == current){
            return;
        }
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        if(leftChild > current && rightChild > current){
            return;
        }
        int minIndex = -1;
        if(rightChild > current){
            minIndex = leftChild;
        }else{
            minIndex = arrList[leftChild] < arrList[rightChild] ? leftChild : rightChild;
        }

        if(arrList[index] < arrList[minIndex]){
            return;
        }
        int temp = arrList[index];
        arrList[index] = arrList[index];
        arrList[minIndex] = temp;
        shiftDown(minIndex);
    }
}
