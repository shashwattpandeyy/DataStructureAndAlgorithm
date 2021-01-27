package StartingPointOftheLoop;

import LinkedList.Node;

public class StartingPointOftheLoop {
    public Node detectCycle(Node head) {
        if(head == null)return null;

        Node slow = head;
        Node fast = head;
        Node start  = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){

                while(start != slow){
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }






        return null;

    }
}
