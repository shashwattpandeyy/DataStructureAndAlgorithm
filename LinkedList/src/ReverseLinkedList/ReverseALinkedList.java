package ReverseLinkedList;

public class ReverseALinkedList {
    public Node reverseList(Node head) {
        Node newHead  = null;
        while(head != null){
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;

    }
}
