package LinkedListCycle;

import LinkedList.Node;

public class LinkedListCycle {
    public boolean hasCycle(Node head) {
        if(head == null || head.next == null)return false;


        Node slow  = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null ){
            slow  = slow.next;
            fast = fast.next.next;
            if(fast == slow)return true;
        }
        return false;
    }
}
