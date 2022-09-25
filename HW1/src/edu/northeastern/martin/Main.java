package edu.northeastern.martin;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode test1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode output1 = rotateRight(test1,10);
        System.out.println();
    }



    //Problem 1
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        int length = 0;
        ListNode cur = head;
        ListNode tail = null;
        while(cur != null){
            if(cur.next == null){
                tail = cur;
            }
            length++;
            cur = cur.next;
        }

        k = k%length;

        if(k == 0){
            return head;
        }
        cur = head;

        ListNode newHead = null;
        for(int i = 0; i < length - k; i++){
            if(i == length-k-1){
                newHead = cur.next;
                cur.next = null;
            }
            cur = cur.next;
        }

        if(newHead == head){
            return head;
        }else{
            tail.next = head;
            return newHead;
        }
    }
    //Problem 2
    public static ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        if(cur == null){
            return null;
        }

        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }

        if(head.val == val){
            head = head.next;
        }

        return head;
    }
    //Problem 3
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        Map<Integer, ListNode> map = new HashMap();
        int i = 1;
        while(cur != null){
            map.put(i++,cur);
            cur = cur.next;
        }
        int temp = map.get(k).val;
        map.get(k).val = map.get(i-k).val;
        map.get(i-k).val = temp;
        return head;
    }

    //Problem 4
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode [] output = new ListNode[k];
        int size = 0;
        ListNode cur = head;
        while(cur != null){
            size++;
            cur = cur.next;
        }
        if(k >= size){
            cur = head;
            for(int i = 0; i < size; i++){
                if(cur != null){
                    ListNode temp = cur;
                    cur =  cur.next;
                    temp.next = null;
                    output[i] = temp;
                }else{
                    output[i] = null;
                }
            }
        }else{
            int     left = k;
            cur = head;
            for (int i = 0; i < k; i++) {
                int curSize = size/left;
                ListNode curHead = cur;
                if(size % left != 0){
                    curSize++;
                }
                for (int j = 0; j < curSize-1; j++) {
                    cur = cur.next;
                }

                ListNode temp = cur;
                cur = cur.next;
                temp.next = null;
                output[i] = curHead;
                size -= curSize;
                left--;
            }
        }
        return output;
    }

    // Problem 5
    public static Node insert(Node head, int insertVal) {
        if(head == null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node cur = head;

        while(true){
            Node insertNode = new Node(insertVal);
            boolean found = (cur.next == head) || //链尾，所有情况都不符合，必须加了
                    (cur.val <= insertVal && insertVal <= cur.next.val) || //中，插入逻辑
                    ((insertVal > cur.val || insertVal <= cur.next.val) && cur.val > cur.next.val); //顺序尾，如果比尾大或者比头小，插入


            if(found){
                insertNode.next = cur.next;
                cur.next =  insertNode;
                return head;
            }
            cur = cur.next;
        }
    }


}
