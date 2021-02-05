package TopologicalSort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/* This sort algo works like Dfs unlike dfs is prints the current value then make a recursive call
    but in topo sort it visites all the neighnours value first then stores in the stack .
    then print  it.
 */
class topologicalSort {
    int V;
    LinkedList<Integer> adj[];

    topologicalSort(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<> ();
        }

    }

    public void addEdge(int source, int destination) {
        adj[source].add ( destination );
    }

    public void topoSortHelper(int src, boolean[] visited , Stack<Integer> stack) {

        visited[src] = true;

        Iterator<Integer> i = adj[src].listIterator ();
        while (i.hasNext ()) {
            int n = i.next ();
            if (!visited[n])
                topoSortHelper ( n, visited , stack );
        }
        stack.push ( src );

    }
    // it uses the stack data structure.

    public void topoSort() {
        Stack<Integer> stack = new Stack<> ();
        boolean[] visited = new boolean[V];
        for(int i = 0; i< V; i++){
            if(visited[i] == false)
                topoSortHelper ( i, visited , stack );
        }
        while(!stack.isEmpty ()){
            System.out.print (stack.pop() + " ");
        }

    }


    public static void main(String[] args) {

        topologicalSort ts = new topologicalSort ( 6 );
        ts.addEdge ( 5,2 );
        ts.addEdge ( 5,0 );
        ts.addEdge ( 4,0 );
        ts.addEdge ( 4,1 );
        ts.addEdge ( 2,3 );
        ts.addEdge ( 3,1 );

        ts.topoSort ();
    }
}
