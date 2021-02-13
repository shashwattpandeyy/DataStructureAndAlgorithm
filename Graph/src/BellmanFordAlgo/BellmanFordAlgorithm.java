package BellmanFordAlgo;

import java.io.Console;
import java.util.Arrays;
import java.util.LinkedList;

public class BellmanFordAlgorithm {
    public static void BellmanFord(LinkedList<Main.Edge>[] adj, int src, int vertices, int Edges){
        int[] distance = new int[vertices];
        Arrays.fill (distance,Integer.MAX_VALUE);
        distance[src] = 0;
        for (int i = 0; i < vertices; i++) {
           for(Main.Edge e : adj[i]){
               if(distance[e.source] != Integer.MAX_VALUE && distance[e.source] + e.weight < distance[e.destination]){
                   distance[e.destination] = distance[e.source] + e.weight;
               }
           }
        }
        for (int j = 0; j < vertices-1; j++) {
            for (Main.Edge e : adj[j]) {
                if (distance[e.source] != Integer.MAX_VALUE && distance[e.source] + e.weight < distance[e.destination]) {
                    System.out.println ( "Graph Contains Cycle " );
                    return;
                }
            }
        }
        for (int i =0; i< distance.length; i++){
            System.out.print("Vertex :" + i + " Distance From Source :" + distance[i]);
            System.out.println ();
        }




    }
}
