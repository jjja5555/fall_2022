package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MaxMinHeap heap = new MaxMinHeap();
        heap.add(2);
        heap.add(4);
        heap.add(2);
        heap.add(5);
        heap.add(2);
        heap.add(1);
        System.out.println(heap.remove());
        heap.add(-1);
        System.out.println(heap.peek());

    }
}
