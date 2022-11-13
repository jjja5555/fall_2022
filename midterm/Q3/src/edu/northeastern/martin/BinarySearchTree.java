package edu.northeastern.martin;

public class BinarySearchTree {
    Node root;
    BinarySearchTree(){
        root = null;
    }

    public void getBST(){
        root = new Node(8);

        root.left = new Node(3);
        root.right = new Node(10);


        root.left.left = new Node(1);
        root.left.right = new Node(6);

        root.right.right = new Node(14);

        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);



        root.right.right.left = new Node(13);
    }

    // Time O(n) n = how many nodes in BST
    // Space O(1) no extra space needed
    public void printRange(int start, int end){
        printHelper(root, start, end);
        System.out.println();
    }

    private void printHelper(Node node, int start, int end){
        if(node == null){
            return;
        }
        printHelper(node.left,start, end);
        if(node.data >= start && node.data <= end)
            System.out.print(node.data + " ");
        printHelper(node.right,start, end);
    }
}
