package edu.northeastern.martin;

public class LinkList  {

    public Node head;

    public int length = 0;

    public LinkList() {
        head = null;
    }

    public void getList(){
        head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(8)))));
        length = 5;
    }

    public void print(){
        printHelper(head);
        System.out.println();
    }

    private void printHelper(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        printHelper(node.next);
    }

    // Time O(n) bad case n = length
    // Space O(1) need to create one new Node
    public void insert(int data){
        // Insert in sorted manner
        if(data < head.data){
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
            return;
        }

        Node current = head;
        while(current.next!= null && current.next.data <= data){
            current = current.next;
        }
        Node next = current.next;
        current.next = new Node(data, next);
        length++;
    }
}