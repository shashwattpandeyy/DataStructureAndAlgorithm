package DoubleEndedList;
// In doubly Linked list we have two reference that is next and previous.

public class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
        this.data = data;
    }
    public void displayNode(){
        System.out.print(this.data + " ");
    }
}
