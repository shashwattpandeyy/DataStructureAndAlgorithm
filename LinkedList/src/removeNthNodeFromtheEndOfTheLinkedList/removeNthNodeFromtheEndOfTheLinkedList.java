package removeNthNodeFromtheEndOfTheLinkedList;

import LinkedList.Node;

public class removeNthNodeFromtheEndOfTheLinkedList {
    public Node removeNthFromEnd(Node head, int n) {

        Node dummy  = new Node(0);
        dummy.next = head;

        Node slow  = dummy;
        Node fast = dummy;


        for(int i = 1; i<=n; i++){
            fast  = fast.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;


        return dummy.next;

    }
}
