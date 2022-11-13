package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkList list = new LinkList();
        list.getList();
        list.print();
        list.insert(6);
        list.print();
        list.insert(7);
        list.print();
        list.insert(10);
        list.print();
        list.insert(-1);
        list.print();

    }
}
