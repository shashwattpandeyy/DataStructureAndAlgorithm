package CycleInGraph;

import java.util.Iterator;
import java.util.LinkedList;

public class CycleDirected {
    /*
        In this we created two arrays visited1 and visited2.In which visited1 keeps the track of all elements.
        and visited2 keep the track of current visiting array means if we try to loop from i --> 1
        and checks its adjacent nodes if they are not visited then we update to true in both visited1 and visited2
        if there is no adjacent nodes from that given element then we backtrack then turn visited2 value to false.

        so now we check again for another node and check if it is visited and if there is some node that points to
        to the next node which is already visited in visited2  then we return true which means the Graph has a cycle.
     */
    private int vertices;
    LinkedList<Integer> adj[];
    public CycleDirected(int v) {
        vertices = v;
        adj = new LinkedList[vertices + 1];
        for (int i = 1; i < vertices; i++) {
            adj[i] = new LinkedList<> ();
        }
    }
    public void addEdges(int source , int destination){
        adj[source].add ( destination );
    }
    public boolean isCycleHelper(int i , boolean[] visited1 , boolean[] visited2){
        visited1[i] = true;
        visited2[i] = true;

        Iterator<Integer> it = adj[i].iterator ();
        while(it.hasNext ()){
            int n = it.next ();
            if(!visited1[n]){
                if(isCycleHelper ( n,visited1,visited2 ))
                    return true;
            }
            else if(visited2[n])
                return true;
        }
        visited2[i] = false;
        return false;
    }
    public boolean isCycle(){
        boolean[] visited1  = new boolean[vertices+1];
        boolean[] visited2 = new boolean[vertices+1];
        for(int i = 1; i<=vertices; i++){
            if(!visited1[i]){
                if(isCycleHelper(i, visited1,visited2))
                        return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDirected cd = new CycleDirected ( 9 );
        cd.addEdges ( 1,2 );
        cd.addEdges ( 2,3 );
        cd.addEdges ( 4,1 );
        cd.addEdges ( 4,5 );
        cd.addEdges ( 5,6 );
        cd.addEdges ( 6,7 );
        cd.addEdges ( 7,4 );
        cd.addEdges ( 7,1 );
        if(cd.isCycle ())
            System.out.println ("Cycle");
        else
            System.out.println ("Not Cycle");
    }

}
