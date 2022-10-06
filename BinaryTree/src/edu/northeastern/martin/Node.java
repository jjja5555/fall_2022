package edu.northeastern.martin;

public class Node {
    int val;
    Node left;
    Node right;

    public Node() {
        this.val = 0;
        left = null;
        right = null;
    }

    public Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
