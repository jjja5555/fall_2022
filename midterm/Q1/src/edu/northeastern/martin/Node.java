package edu.northeastern.martin;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node nextLeft;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.nextLeft = null;
    }

    public Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
        this.nextLeft = null;
    }
}