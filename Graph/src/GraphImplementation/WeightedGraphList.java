package GraphImplementation;

import java.util.LinkedList;

public class WeightedGraphList {
    int V;
    LinkedList<Edge> adj[];
    public WeightedGraphList(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i =0;i<v; i++){
            adj[i] = new LinkedList<> ();
        }
    }
    class Edge{
        int end , weight;
        public Edge(int e , int w){
            this.end = e;
            this.weight = w;
        }

        @Override
        public String toString() {
            return "{" +
                    + end +  "," + weight +
                   '}';
        }
    }

    public void AddEdge(int s, int e, int w){
        adj[s].add ( 0,new Edge ( e,w ) );

    }

    public void Display(){
        for(int i = 0; i< adj.length; i++){
            System.out.print(i + " - > " + adj[i] );
            System.out.println ();

        }
     }

    public static void main(String[] args) {
        WeightedGraphList wgl =new WeightedGraphList ( 8 );
        wgl.AddEdge ( 0,1,2 );
        wgl.AddEdge ( 0,2,4 );
        wgl.AddEdge ( 2,3,6);
        wgl.AddEdge ( 3,4,8);

        wgl.AddEdge ( 3,5,5);
        wgl.AddEdge ( 5,6,7);
        wgl.AddEdge ( 5,8,9);


        wgl.Display ();


    }
}
