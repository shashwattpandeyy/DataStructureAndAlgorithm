package LinkedList;

// This node class contains data and the reference to the next element.
public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
    public void DisplayNode(){
        System.out.print (this.data + " ");
    }
}
