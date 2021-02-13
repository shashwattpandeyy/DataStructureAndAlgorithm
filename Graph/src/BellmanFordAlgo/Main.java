package BellmanFordAlgo;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static class Edge{
        int source;
        int destination;
        int weight;
        public Edge(int s, int d, int w){
            this.source = s;
            this.destination = d;
            this.weight = w;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Enter Vertices");
        int vertices = sc.nextInt ();
        System.out.println ("Enter Edges");
        int Edges = sc.nextInt ();
        LinkedList<Edge> adj[]= new LinkedList[vertices];
        for(int i =0; i<vertices; i++) {
            adj[i] = new LinkedList<> ();
        }

            for (int i = 0; i < Edges; i++) {
            System.out.println ("Enter source");
            int s = sc.nextInt ();
            System.out.println ("Enter destination");
            int d = sc.nextInt ();
            System.out.println ("Enter weight");
            int w = sc.nextInt ();
            adj[s].add ( new Edge ( s,d,w ) );

        }
        int src = sc.nextInt ();
        BellmanFordAlgorithm.BellmanFord (adj,src,vertices,Edges);

    }
}
