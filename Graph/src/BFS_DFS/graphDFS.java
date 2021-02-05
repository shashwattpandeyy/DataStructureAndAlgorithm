package BFS_DFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* this is implemented by graph as a list and we have DFS here.

 */
public class graphDFS {
    int V;
    LinkedList<Integer> adj[];

    public graphDFS(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList ();
        }
    }

    public void addEdges(int src, int des, boolean bidirectional) {
        adj[src].add ( des );

        if (bidirectional == true) {
            adj[des].add ( src );
        }
    }
    /* this is a recursive function dfshelper it takes
        two parameter src and visited to keep the track of visited elements.
        and src is the starting node of the DFS
     */

    public void dfsHelper(int src, boolean visited[]) {
        visited[src] = true;
        System.out.print( src + " " );

        Iterator<Integer> i = adj[src].listIterator ();
        while (i.hasNext ()) {
            int n = i.next ();
            if (!visited[n])
                dfsHelper ( n, visited );
        }
    }

    public void dfs(int src) {
        boolean visited[] = new boolean[V];
        dfsHelper ( src, visited );
    }


    public static void main(String[] args) {
        graphDFS g = new graphDFS ( 4 );
        g.addEdges ( 0, 1, true );
        g.addEdges ( 0, 2, true );
        g.addEdges ( 0, 3, true );
        //g.addEdges ( 1, 5, true );
        g.addEdges ( 1, 2, true );
        System.out.println("DFS "  );

        g.dfs (0);
    }

}
