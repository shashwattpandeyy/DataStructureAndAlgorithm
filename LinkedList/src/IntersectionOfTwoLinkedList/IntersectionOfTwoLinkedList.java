package IntersectionOfTwoLinkedList;

import LinkedList.Node;

public class IntersectionOfTwoLinkedList {
    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null)return null;

        Node a = headA;
        Node b = headB;

        while(a != b){
            if(a != null){
                a = a.next;
            }
            else
                a = headB;

            if(b != null){
                b = b.next;
            }
            else
                b = headA;
        }
        return a;
    }
}
