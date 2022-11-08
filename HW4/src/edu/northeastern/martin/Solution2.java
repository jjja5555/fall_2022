package edu.northeastern.martin;

public class Solution2 {
    private Node newHead = null;
    private Node newTail = null;

    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        helper(root);
        newHead.left = newTail;
        newTail.right = newHead;
        return newHead;
    }

    private void helper(Node node){
        if(node == null){
            return;
        }

        helper(node.left);
        if(newTail != null){
            newTail.right = node;
            node.left = newTail;
        }else{
            newHead = node;
        }
        newTail = node;
        helper(node.right);

    }
}
