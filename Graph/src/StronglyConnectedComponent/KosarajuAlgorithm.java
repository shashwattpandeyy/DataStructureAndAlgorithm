package StronglyConnectedComponent;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class KosarajuAlgorithm {
    /*
    The above algorithm is DFS based. It does DFS two times.
    In this we traverse a graph by DFS ans store all the values in stack.
    Now we transpose the adjacency list and pop the elements out of stack and again we traverse all the element
    which is popped and adjacent to that popped element now we print
     */
    final int vertices;
    final LinkedList<Integer> adj[];
    Stack<Integer> s = new Stack<> ();

    public KosarajuAlgorithm(int v){
        vertices = v;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices ; i++) {
            adj[i] = new LinkedList<> ();
        }
    }

    public void addEdge(int s , int d){
        adj[s].add ( d );
    }

    public void DFSHelper(int i, boolean[] visited){

        visited[i] = true;

        Iterator<Integer> it = adj[i].iterator ();
        while(it.hasNext ()){
            int n = it.next ();
            if(!visited[n])
                DFSHelper ( n, visited );
        }
        s.push( i );
    }
    public void DFSHelperr(int i, boolean[] visited1){

        visited1[i] = true;
        System.out.print(i + " ");

        Iterator<Integer> it = adj[i].iterator ();
        while(it.hasNext ()) {
            int n = it.next ();
            if (!visited1[n])
                DFSHelperr ( n, visited1 );

        }
    }

    KosarajuAlgorithm getTranspose(){
        KosarajuAlgorithm k = new KosarajuAlgorithm ( vertices );
        for (int i = 0; i < vertices ; i++) {
            Iterator<Integer> it = adj[i].iterator ();
            while (it.hasNext ()){
                k.adj[it.next ()].add ( i );
            }
        }
        return k;
    }
    public void printSCC(){
          DFS ();
          KosarajuAlgorithm ks = getTranspose ();
          boolean[] visited1 = new boolean[vertices];
          while (!s.isEmpty ()){
              int p = s.pop ();
              if (!visited1[p]){
                  ks.DFSHelperr ( p, visited1 );
                  System.out.println ();
              }
          }
    }


    public void DFS(){
        boolean[] visited = new boolean[vertices];
        for(int i = 0; i<vertices; i++){
            if(!visited[i]){
                DFSHelper(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        KosarajuAlgorithm ka  = new KosarajuAlgorithm ( 5 );
        ka.addEdge ( 1,0 );
        ka.addEdge ( 0,2 );
        ka.addEdge ( 2,1 );
        ka.addEdge ( 0,3 );
        ka.addEdge ( 3,4 );
        ka.printSCC ();

    }
}
