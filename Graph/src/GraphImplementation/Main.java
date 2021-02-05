package GraphImplementation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
    This is the implementation of GraphImplementation. Graph using hashmap
    basically graph can be implemented by graph as a map ans graph as a list.
    Also this is Generic graph you can implement integer as well as string whatever you want
 */
class Graph<E>{
    private HashMap<E , List<E>> hashMap = new HashMap<> ();

    /* here addvertices takes a vertex means source or destination and treated as a key so
        hashmap works as a key and value.
       vertex is key and all the values will be stored in linkedlist.

     */
    public void addVertices(E vertex){
        hashMap.put ( vertex , new LinkedList<E> () );
    }

    /* this fuction add the edges between two vertices to here
       bidirectional means the graph is we can add two sided edges
       eg 0 -> 1, 1->0.
       also this is unweighted graph.
     */
    public void addEdges(E source , E destination , boolean bidirectional ){
        if(!hashMap.containsKey ( source )){
            addVertices ( source );
        }
        if(!hashMap.containsKey ( destination ))
            addVertices ( destination );

        hashMap.get ( source ).add ( destination );
        if(bidirectional == true)
            hashMap.get (destination).add ( source );
    }



    public void Display(){

        for( E e : hashMap.keySet ())
        {
            System.out.print(( e +  ": "));
            for(E a : hashMap.get ( e )){
                System.out.print(( a + " " ));
            }
            System.out.println ();
        }

    }




    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<Integer> ();
        Graph<String> g1 = new Graph<String> ();
//        graph.addEdges ( 0,1, true);
//        graph.addEdges ( 1,2,true );
//        graph.addEdges ( 2,3,true );
//        graph.addEdges ( 3,4,true );
//        graph.addEdges ( 0,3,true );
//        graph.addEdges ( 1,4,true );


        //   graph.Display ();

        g1.addEdges ( "rewa", "allahabad",true );
        g1.addEdges ( "rewa", "delhi",true );
        g1.addEdges ( "delhi", "indore",true );
        g1.addEdges ( "indore", "rewa",true );
        g1.addEdges ( "indore", "bhopal",true );
        g1.Display();
    }
}
