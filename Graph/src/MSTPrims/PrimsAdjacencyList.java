package MSTPrims;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsAdjacencyList {
    static class node {
        int vertex , weight;
        node(int v , int w){
            this.vertex = v;
            this.weight = w;
        }
    }


        public static int MST(LinkedList<node> adj[]){

            int n = adj.length;
            int cost = 0;
            boolean[] visited = new boolean[n];


            PriorityQueue<node> minHeap = new PriorityQueue<> ( new Comparator<node> () {
                @Override
                public int compare(node o1, node o2) {
                    return o1.weight - o2.weight;
                }
            } );
            minHeap.add ( new node ( 0,0 ) );
            while(!minHeap.isEmpty ()){
                node neighbour = minHeap.poll ();
                if(!visited[neighbour.vertex])continue;
                cost += neighbour.weight;
                for(int i = 0; i < adj[ neighbour.vertex ].size (); i++){
                    node v = adj[neighbour.vertex].get ( i );
                    if(!visited[v.vertex]){
                        minHeap.add ( adj[v.vertex].get ( i ) );

                    }
                }
            }


            return cost;
        }



    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        int N = sc.nextInt ();
        int E = sc.nextInt ();
        LinkedList<node> adj[] = new LinkedList[N];
        for(int i = 0; i< N; i++) {
            adj[i] = new LinkedList<> ();
        }
        for(int i = 0;i< E; i++) {
            int x = sc.nextInt ();
            int y = sc.nextInt ();
            int w = sc.nextInt ();
            adj[x].add (  new node ( y,w ));
            adj[y].addLast ( new node ( x,w ) );
        }


        int min = MST(adj);

        System.out.println (min);

    }
}
