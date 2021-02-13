package MSTPrims;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MSTKruskals {


    public static int KruskalsAlgorithm(PriorityQueue<Edge> pq , int vertex){
        DisjointSet ds= new DisjointSet ( vertex );
        int neighbours = vertex;
        int cost = 0;

        while(!pq.isEmpty ()){
            if(neighbours <=1)
                break;

            Edge edge = pq.remove ();
            if(ds.find ( edge.start ) == ds.find ( edge.end ))
                continue;

            ds.union ( edge.start, edge.end );
            neighbours--;
            cost += edge.cost;
        }

        if(neighbours > 1)
            return -1;
        else
            return cost;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in );
        System.out.println ("Enter vertices");
        int V = sc.nextInt ();
        System.out.println ("Enter edge");
        int E =  sc.nextInt ();

        PriorityQueue<Edge>  pq = new PriorityQueue<> ();
        System.out.println ("Make connection : ");
        for (int i = 0; i<E; i++){
            int start = sc.nextInt ();
            int finish = sc.nextInt ();
            int cost  = sc.nextInt ();
            pq.add ( new Edge ( start, finish, cost) );
        }

        int cost = KruskalsAlgorithm( pq, V);

        System.out.println (cost);


    }


    static class Edge implements Comparable<Edge>{
        int start , end , cost;
        public Edge(int s, int e, int c){
            this.start = s;
            this.end = e;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static class DisjointSet{
        private int[] parent;
         public DisjointSet(int v){
             parent = new int[v];
             for (int i = 0; i<v; i++){
                 parent[i] = i;
             }
         }


         public int  find(int x){
             if(parent[x] == x){
                 return x;
             }
             parent[x] = find ( parent[x] );
             return parent[x];
         }

         public void union(int x , int y){
             parent[find ( x )] = find ( y );
         }
    }
}
