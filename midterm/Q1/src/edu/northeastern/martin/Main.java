package edu.northeastern.martin;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Node testNode = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
        populateNextLeft(testNode);
        System.out.println("Put break point here");
    }

    // BFS
    // Time O(n) n = how many nodes in the tree
    // Space O(n) n = how many nodes in the tree
    public static void populateNextLeft(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);



        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                current.nextLeft = pre;
                pre = current;
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
        }
    }
}
