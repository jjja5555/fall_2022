package edu.northeastern.martin;

import java.util.zip.CheckedInputStream;

public class Main {

    static int maxHeight = 0;
    public static void main(String[] args) {
	// write your code here
        Node head = new Node(1,new Node(2,new Node(4,new Node(6),null),new Node(5, new Node(6),new Node(7))),null);
        System.out.println(height(head));
        System.out.println(findMaxLength(head));
    }


    private static int height(Node head){
        int left = 0;
        int right = 0;


        if(head == null)
            return 0;
        if(head.left != null){
            left = height(head.left);
        }

        if(head.right != null){
            right = height(head.right);
        }
        int length = 1 + left + right;
        if( length> maxHeight){
            maxHeight = length;
        }
        return left > right ? 1 + left : 1 + right;
    }

    public static int findMaxLength(Node head){
        maxHeight = 0;
        height(head);
        return maxHeight;
    }
}
