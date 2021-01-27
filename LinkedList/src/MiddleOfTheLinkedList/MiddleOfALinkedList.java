package MiddleOfTheLinkedList;

import LinkedList.Node;
      /*  intput: [1,2,3,4,5]
        Output: Node 3 from this list (Serialization: [3,4,5])
        The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).

       */
public class MiddleOfALinkedList {
    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;

    }
}
