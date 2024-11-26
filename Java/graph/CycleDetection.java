package graph;

import graph.Classroom.Edge;
import java.util.*;

public class CycleDetection {


    // UnDirected Graph
    public static boolean isCyclicUndirHelper(ArrayList<Edge>[] graph, int src, int parent, boolean[] visited){
        visited[src] = true;

        for(Edge e : graph[src]){
            if(!visited[e.dest]){
                if(isCyclicUndirHelper(graph, e.dest, src, visited)){
                    return true;
                }
            }
            else{
                if(e.dest != parent){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclicUndir(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];

        return isCyclicUndirHelper(graph, 0, -1, visited);
    }


    //Directed Graph
    public static boolean isCyclicDir(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        //filling recursionStack with all false values
        boolean[] recursionStack = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                if(isCyclicDirHelper(graph, i, visited, recursionStack)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclicDirHelper(ArrayList<Edge>[] graph, int src, boolean[] visited, boolean[] recurrsionStack){
        visited[src] = true;
        recurrsionStack[src] = true;

        for(Edge e : graph[src]){
            if(!visited[e.dest]){
                if(isCyclicDirHelper(graph, e.dest, visited, recurrsionStack)){
                    return true;
                }
            }
            else{
                //visited and in recursionStack
                if(recurrsionStack[e.dest] == true){
                    return true;
                }
            }
        }
        recurrsionStack[src] = false;
        return false;
    }

    //Print Graph
    private static void printGraph(ArrayList<Edge>[] graph){
        for(int i=0; i < graph.length;i++){
            System.out.print( i + " -> ");
            //print its neighbours
            for(Edge e : graph[i]){
                System.out.print(e.dest + " ");
            }
            System.out.println();
        }
    }


    public static void main2(){

        int V = 5;
        ArrayList<Edge>[] gp = new ArrayList[V];
        for(int i=0; i<V;i++){
            gp[i] = new ArrayList<>();
        }

        //Undirected Graph
        gp[0].add(new Edge(0,1,1));
        gp[0].add(new Edge(0,2,1));

        gp[1].add(new Edge(1,0,1));
        gp[1].add(new Edge(1,3,1));
        gp[1].add(new Edge(1,2,1));
        gp[2].add(new Edge(2,0,1));
        gp[3].add(new Edge(3,4,1));
        gp[3].add(new Edge(3,1,1));
        gp[4].add(new Edge(4,3,1));
        
        //Print Graph
        printGraph(gp);

        //Check if graph is cyclic
        System.out.println(isCyclicUndir(gp));

        // Undirected Graph
        int V1 = 4;
        ArrayList<Edge>[] graph = new ArrayList[V1];
        for(int i=0; i<V1;i++){
            graph[i] = new ArrayList<>();

        }

        graph[0].add(new Edge(0,2,1));
        graph[1].add(new Edge(1,0,1));
        graph[2].add(new Edge(2,3,1));
        graph[3].add(new Edge(3,0,1));

        printGraph(graph);
        System.out.println(isCyclicDir(graph));

    }


    public static void main(String[] args) {

        main2();

    }


}
