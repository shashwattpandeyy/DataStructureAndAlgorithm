package LinkedList;

public class Linked {

        private Node head;
        // Linked is constructor.
        public Linked() {
            head = null;
        }
        // This function checks whether the LinkedList is empty or not
        public boolean isEmpty(){
            return (head == null);
        }
        // It inserts the data in 1st position.
        public void InsertFirst(int data){
            Node node = new Node ( data );
            node.next = head;
            head = node;
        }
    // It inserts the data in last position.
        public void InsertAtLast(int data){
            Node node = new Node ( data );
            node.next = null;
            if(head == null){
                head = node;
            }
            else{
                Node n = head;
                while (n.next != null){
                    n=n.next;
                }
                n.next= node;
            }
        }
        // this function finds the data is present in the linked list or not.
        public Node find(int key) throws Exception {
            Node node = head;
            while(node.data != key){
                if(node == null){
                    throw new Exception ( "Not Found Elements" );
                }

                else
                    node = node.next;
            }
            return node;
        }
    // It inserts the data in between the 1st and the last position.
        public void InsertAtAnyPostion(int index , int data){
            Node node = new Node(data);
            if (index ==0){
                InsertFirst ( data );
            }else{
                Node n = head;
                for (int i = 0; i <index-1 ; i++) {
                    n=n.next;
                }
                node.next = n.next;
                n.next = node;
            }
        }
    // It deletes the data in 1st position.
        public Node DeleteFirst(){
            Node temp = head;
            head = head.next;
            return temp;
        }
        public void Display(){
            Node node = head;
            System.out.print("[ ");
            while( node != null){
                node.DisplayNode ();
                node = node.next;
            }
            System.out.println ("]");
            System.out.println (" ");
        }
    }


