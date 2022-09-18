package edu.northeastern.martin;

public class LinkedList <T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;


    public LinkedList() {
       head = null;
       tail = null;
       size = 0;
    }

    public void add (T data){
        if(head == null){
            head = new Node<>(data);
            tail = head;
        }else{
            tail.next = new Node<>(data);
            tail = tail.next;
        }
        size++;
    }

    // O(n)
    public void printList(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            Node cur = head;
            while(cur != null){
                System.out.print(cur.data + " -> ");
                cur = cur.next;
            }
            System.out.print("null\n");
        }

    }

    public void add2head(T data){
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    public int length(){
        int count = 0;
        Node cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    public boolean containsCycle(){
        if(head == null || head.next == null){
            return false;
        }

        Node front = head;
        Node back = head;

        while(back != null && back.next != null){
            front = front.next;
            back = back.next.next;
            if(front == back){
                return true;
            }
        }
        return false;
    }
}
