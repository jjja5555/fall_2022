package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList <Integer> a = new LinkedList<Integer>();
        a.add(1);
        a.add(3);
        a.add(5);
        a.add(5);
        a.printList();

        LinkedList <String> strList = new LinkedList<String>();
        strList.add("fdsafd");
        strList.add("huang");
        strList.add("xao");
        strList.add("martin");
        strList.printList();
        System.out.println(strList.length());

        LinkedList<Integer> defaultList = new LinkedList<>();

    }
}
