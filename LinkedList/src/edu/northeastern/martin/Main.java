package edu.northeastern.martin;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList <Integer> a = new LinkedList<Integer>();
        Node <Integer> num1 = new Node<Integer>(2);
        num1.next = new Node<>(3);
        num1.next.next = new Node<>(9);

        Node <Integer> num2 = new Node<Integer>(9);
        num2.next = new Node<>(8);

        Node out = add2Sum(num1,num2);
        a.add(1);
        a.add(3);
        a.add(5);
        a.add(5);
        a.printList();

        NodeRandom sample = new NodeRandom(1);
        sample.next = new NodeRandom(2);
        sample.next.next = new NodeRandom(3);
        sample.next.next.next = new NodeRandom(4);
        sample.random = sample.next.next.next;
        sample.next.random = sample;
        sample.next.next.random = sample.next.next.next;
        sample.next.next.next.random = sample;


        NodeRandom second = copyRandom(sample);
        LinkedList <String> strList = new LinkedList<String>();
        strList.add("fdsafd");
        strList.add("huang");
        strList.add("xao");
        strList.add("martin");
        strList.printList();
        System.out.println(strList.length());

        LinkedList<Integer> defaultList = new LinkedList<>();

    }


    public static NodeRandom copyRandom (NodeRandom node){

        NodeRandom outNode = new NodeRandom(node.data);
        NodeRandom cur = node;
        NodeRandom curNew = outNode;

        Map<NodeRandom, NodeRandom> map = new HashMap<>();
        map.put(cur,curNew);
        while(cur.next != null){
            curNew.next = new NodeRandom(cur.next.data);
            map.put(cur.next,curNew.next);
            cur = cur.next;
            curNew = curNew.next;
        }

        cur = node;
        curNew = outNode;
        while(cur != null){
            curNew.random = map.get(cur.random);
            cur = cur.next;
            curNew = curNew.next;
        }

        return outNode;
    }

    public static Node add2Sum(Node num1, Node num2){
        int carry = 0;
        Node <Integer>temp1 = num1;
        Node <Integer>temp2 = num2;

        Node outNode = new Node(0);
        Node cur = outNode;
        while(temp1 != null || temp2 != null){
            int result = 0;
            result += carry;
            carry = 0;

            if(temp1 != null){
                result += temp1.data;
                temp1 = temp1.next;
            }

            if(temp2 != null){
                result += temp2.data;
                temp2 = temp2.next;
            }

            if(result > 9){
                carry++;
                result -= 10;
            }

            cur.next = new Node(result);
            cur = cur.next;
        }

        if(carry > 0){
            cur.next = new Node(carry);
        }

        return outNode.next;
    }
}
