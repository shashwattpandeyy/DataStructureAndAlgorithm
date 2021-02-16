package CycleInGraph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class CycleUndirected {
    /*
        In undirected graph G, we keeps the track of its parent element it is why because is its adjacent node is
        coming from the parent node then we simply check if parent == current node then there is no cycle
        if parent != current then there is a cycle.
     */
    LinkedList<Integer> adj[];
    int vertices;
    public CycleUndirected(int v){
        vertices = v;
        adj  = new LinkedList[vertices];
        for (int i = 0; i < vertices ; i++) {
            adj[i] = new LinkedList<> ();
        }
    }

    public void addEdges(int source, int destination,boolean bidirectional){
        adj[source].add ( destination );
        if(bidirectional == true)
            adj[destination].add ( source );

    }

    public boolean isCycle(){
        boolean[] visited = new boolean[vertices];
        Arrays.fill ( visited, false );

        for(int i = 0; i<vertices; i++) {
            if(!visited[i])
                if (isCycleHelper ( i, visited, -1 )) {
                    return true;
            }
        }

        return false;
    }

    private Boolean isCycleHelper(int i, boolean[] visited, int parent) {
        visited[i] = true;
        Iterator<Integer> it = adj[i].iterator ();
        while (it.hasNext ()){
            int n  = it.next ();
            if(!visited[n]) {
                if (isCycleHelper ( n, visited, i )) {
                    return true;
                }
            }

            else if(n != parent)
                return true;

        }
        return false;
    }

    public static void main(String[] args) {

        CycleUndirected cd = new CycleUndirected (5);
        cd.addEdges ( 1,0,true );
        cd.addEdges ( 0,2,true );
        cd.addEdges ( 2,1,true );
        cd.addEdges ( 0,3,true );
        cd.addEdges ( 3,4,true );
        if(cd.isCycle ())
            System.out.println ("Contain Cycle");
        else
            System.out.println ("Not conatin cycle");

        CycleUndirected cd1 = new CycleUndirected (3);
        cd1.addEdges ( 0,1,true );
        cd1.addEdges ( 1,2,true );
        if(cd1.isCycle ())
            System.out.println ("Contain cycle");
        else
            System.out.println ("Not");
    }
}
