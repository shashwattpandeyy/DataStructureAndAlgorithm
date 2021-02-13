package DjikstraAlgo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DjikstraAlgo {

    /*
     * Dijkstra's algorithm finds the shortest path on a weighted graph between
     * any two vertices. In order to do this, we will utilize a PriorityQueue, which
     * functions the same as a regular queue (push and pop elements), but
     * is different in that it sorts the elements in the queue as they are pushed
     * into it. The PriorityQueue will be sorting vertices based on the minimum
     * distance up to each vertex. Dijkstra's algorithm works by first setting the
     * minimum distance of the source vertex to 0, and setting the minimum distance
     * of every other vertex to infinity (Integer.MAX_VALUE in this case). Now we
     * examine each neighbor of the source vertex and see if the current distance
     * added with the distance between the vertices is smaller than the minimum
     * distance of the neighboring vertex. If it is, then we remove that neighboring
     * vertex from the queue, update it's minimum distance, and push it back into
     * the queue so it can be sorted once again. After visiting all neighbors who
     * have yet to be visited, we set the current vertex to the vertex with the lowest
     * minimum distance who has yet to be visited, or, the next vertex out of the
     * queue. We repeat this process until there are no vertices left in the queue,
     * or we have visited our destination vertex. If the minimum distance of the
     * destination vertex is still at infinity, then we know it has not been visited,
     * otherwise, we return the minimum distance of the destination vertex.
     */
    public static class Edge{
        int source;
        int destination;
        int distance;
        public Edge(int s, int d, int dis){
            this.source = s;
            this.destination = d;
            this.distance = dis;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int vertex = sc.nextInt();
        int edges = sc.nextInt ();
        LinkedList<Edge> graph[] = new LinkedList[vertex];
        for(int i = 0; i<vertex; i++){
            graph[i] = new LinkedList<> ();
        }
        for(int i = 0; i<edges; i++){
            int source = sc.nextInt ();
            int destination = sc.nextInt();
            int distance = sc.nextInt ();
            graph[source].add ( new Edge ( source, destination, distance ) );
            graph[destination].add ( new Edge ( destination, source, distance ) );
        }
        int src = sc.nextInt ();
        int ans = Djikstra (graph , src , vertex);
        System.out.println (ans);

    }


    public static int Djikstra(LinkedList<Edge>[] graph, int src, int vertex){
        //Create pq using minHeap it implements comparable because we have to assign minimum value int priority Queue.
        PriorityQueue<pair> pq = new PriorityQueue<> ();
        pq.add ( new pair ( src,0 ) );
        //keep the track of visited element.
        boolean[] visited = new boolean[vertex];
        int[] Distance = new int[vertex];
        //fill all the element int array with maximum value first.
        Arrays.fill (Distance, Integer.MAX_VALUE);
        //Because we have to provide source vertex the we have to initialise source vertex to zero.
        Distance[0] = 0;
        //Loop until the pq is not empty.
        while(!pq.isEmpty ()){
            pair p = pq.remove ();

            visited[p.v] = true;
            //check for the adjacent neighbour.
            for(Edge e : graph[p.v]){
                if(visited[e.destination] == false) {
                    int distance = e.distance;
                    //newDistance keeps track of the distance up to the current vertex added with the distance
                    //between the current vertex and the end vertex
                    int newDistance = Distance[p.v] + distance;

                    //if the newDistance is less than the minimum distance of the end vertex, replace it
                    if (newDistance < Distance[e.destination])
                        Distance[e.destination] = newDistance;

                    pq.add ( new pair ( e.destination, Distance[e.destination] ) );
                }
            }
        }
        int total = 0;
        for(int i = 0; i<Distance.length; i++){
            total += Distance[i];
        }
        return total;
    }



    static class pair implements Comparable<pair>{
        int v;
        //String psf;
        int wt;

        public pair(int v, int wt) {
            this.v = v;
          //  this.psf = psf;
            this.wt = wt;
        }

        @Override
        public int compareTo(pair o) {
            return this.wt - o.wt;
        }
    }
}
