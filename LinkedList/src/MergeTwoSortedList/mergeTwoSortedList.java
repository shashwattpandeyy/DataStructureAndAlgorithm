package MergeTwoSortedList;

import LinkedList.Node;

public class mergeTwoSortedList {
    public Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null)return l2;
        if(l2 == null)return l1;
        if(l1.data > l2.data){
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        Node result = l1;
        while(l1 != null && l2 != null){
            Node temp = null;
            while(l1 != null && l1.data <= l2.data){
                temp  = l1;
                l1 = l1.next;
            }

            temp.next = l2;
            temp = l1;
            l1 = l2;
            l2  = temp;

        }
        return result;
    }
}
