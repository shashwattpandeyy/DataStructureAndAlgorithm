package RotateList;

import LinkedList.Node;

public class RotateLinkedlIst {
    public Node rotateRight(Node head, int k) {

        if(head == null || head.next == null || k==0)return head;

        Node curr = head;
        int len = 1;

        while(curr.next != null){
            len++;
            curr = curr.next;
        }

        curr.next = head;

        k = k% len;
        k  = len - k;

        while(k-- > 0)curr = curr.next;

        head = curr.next;
        curr.next  = null;

        return head;
    }
}
