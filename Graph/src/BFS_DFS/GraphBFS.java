package BFS_DFS;

import java.util.*;
/*
    All the comments are same as DFS but in the bfsHelper we used queue DS to implement it.
 */
public class GraphBFS {
    int V;
    LinkedList<Integer> adj[];

    public GraphBFS(int v) {
        V = v;
        adj = new LinkedList[V];

        for(int i  =0; i<V; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdges(int source , int destination , boolean bidirect){
        adj[source].add ( destination );
        if(bidirect == true)
            adj[destination].add ( source );
    }

    public void bfsHelper(int src , boolean[] visited){
        Queue<Integer> q  = new ArrayDeque<> ();
        q.add ( src );
        visited[src]= true;

        while(!q.isEmpty ()){
            int next = q.peek ();
            q.poll ();
            System.out.print(next + " ");
            for(int nb : adj[src]){
                if(!visited[nb]){
                    bfsHelper ( nb,visited );
                }
            }
        }
    }

    public void bfs(int src){
        boolean[] visited = new boolean[V];
        bfsHelper(src , visited);
    }


    public static void main(String[] args) {
        GraphBFS bfs = new GraphBFS ( 6 );
        bfs.addEdges ( 0,1,true );
        bfs.addEdges ( 0,3,true );
        bfs.addEdges ( 1,2,true );
        bfs.addEdges ( 3,2,true );
        bfs.addEdges ( 3,4,true );
        bfs.addEdges ( 4,5,true );

        bfs.bfs ( 2);
    }
}
