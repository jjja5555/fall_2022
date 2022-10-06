package edu.northeastern.martin;

public class NodeRandom {
    public int data;
    public NodeRandom next;
    public NodeRandom random;

    public NodeRandom(int data, NodeRandom next) {
        this.data = data;
        this.next = next;
        this.random = null;
    }
    public NodeRandom(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}
