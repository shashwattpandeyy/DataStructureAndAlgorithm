package LinkedListPalindrome;

import LinkedList.Node;

public class LinkdedListPalindrone {
    public boolean isPalindrome(Node head) {
        if(head == null || head.next == null)return true;

        Node slow  = head;
        Node fast = head;
        while( fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverseList(slow.next);

        slow = slow.next;


        while(slow != null){

            if(head.data != slow.data)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;


    }
    Node reverseList(Node head){

        Node dummy  = null;
        Node next  = null;
        while(head != null){
            next = head.next;
            head.next = dummy;
            dummy  = head;
            head = next;
        }
        return dummy;


    }
}
