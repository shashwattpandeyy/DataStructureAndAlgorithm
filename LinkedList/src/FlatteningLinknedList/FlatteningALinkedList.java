package FlatteningLinknedList;

/* Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
class Node

 */
class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

public class FlatteningALinkedList {
    Node mergeNode(Node a , Node b){
        Node temp = new Node(0);
        Node res  = temp;

        while(a != null && b != null){
            if(a.data < b.data){
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            }


            else{
                temp.bottom  = b;
                temp = temp.bottom;
                b = b.bottom;

            }
        }

        if( a != null)temp.bottom = a;
        else
            temp.bottom  = b;

        return res.bottom;
    }

    Node flatten(Node root)
    {
        if(root == null || root.next == null )
            return root;

        root.next = flatten(root.next);

        root = mergeNode(root , root.next);

        return root;





    }
}
