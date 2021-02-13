package MSTPrims;

import java.util.Arrays;

public class MSTprims {




    public static int  MST(int graph[][]){
        int n  = graph.length;
        int cost = 0;
        boolean[] visited = new boolean[n];
        int[] weight = new int[n];
        Arrays.fill (weight, Integer.MAX_VALUE);
        weight[0] = 0;
        for(int i = 0; i<n; i++){
            int min = minEdgeVertex(weight , visited);
            cost += weight[min];
            visited[min] = true;
            weight[min] = 0;
            updateWeight(weight, visited, graph, min);
        }
        return cost;
    }

    public static int minEdgeVertex(int [] weight, boolean[] visited){
        int minIndex = -1 , min = Integer.MAX_VALUE;
        for (int i = 0; i<weight.length; i++){
            if(visited[i] == false && weight[i]  < min) {
                min = weight[i];
                minIndex = i;
            }
        }
        return minIndex;

    }
    public static void updateWeight(int[] weight, boolean[] visited, int[][] graph, int min){
        int n = weight.length;
        for(int i = 0; i<n; i++){
            if(graph[i][min] != 0 && visited[i] == false){
                weight[i] = Math.min(weight[i] , graph[i][min]);
            }
        }
    }



    public static void main(String[] args) {
        MSTprims mst = new MSTprims ();
        int graph[][] = new int[][] {{ 0, 2, 0, 6, 0 },
                                    { 2, 0, 3, 8, 5 },
                                    { 0, 3, 0, 0, 7 },
                                    { 6, 8, 0, 0, 9 },
                                    { 0, 5, 7, 9, 0 }};

        int cost = MSTprims.MST ( graph );
        System.out.println (cost);
    }
}
