package edu.northeastern.martin;

import java.util.LinkedList;
import java.util.Queue;

public class Solution6 {
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                sb.append('*');
                sb.append(',');
                continue;
            }
            sb.append(temp.val);
            sb.append(',');
            queue.add(temp.left);
            queue.add(temp.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("") || data.equals("*,"))return null;
        String [] arr = data.split(",");
        TreeNode head = new TreeNode(Integer.valueOf(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int index = 1;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(!arr[index].equals("*")){
                temp.left = new TreeNode(Integer.valueOf(arr[index]));
                queue.add(temp.left);
            }
            index++;
            if(!arr[index].equals("*")){
                temp.right = new TreeNode(Integer.valueOf(arr[index]));
                queue.add(temp.right);
            }
            index++;
        }
        return head;
    }
}