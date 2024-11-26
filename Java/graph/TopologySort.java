package graph;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class TopologySort {

    static class Edge{
        int src;
        int dest;

        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
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

    static void addEdge(ArrayList<Edge>[] graph, int src, int dest, boolean isUnDirected){
        graph[src].add(new Edge(src, dest));
        if(isUnDirected)
            graph[dest].add(new Edge(dest, src));
    } 

    private static void dfsHelper(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> stack){
        visited[src] = true;

        // Process all neighbors of the current node
        for(Edge e: graph[src]){
            if(!visited[e.dest]){
                dfsHelper(graph, e.dest, visited, stack);
            }
        }

        // Push the current node to the stack
        stack.push(src);
    }

    //DFS
    public static void topologySort(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                dfsHelper(graph, i, visited, stack);
            }
        }

        //Print Values in Stack
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0 ;i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 1));
    }

    private static void calculateIndegree(ArrayList<Edge>[] graph, int[] indegree){
        for(int i=0; i<graph.length;i++){
            for(Edge e : graph[i]){
                indegree[e.dest]++;
            }
        }
    }

    //BFS
    private static void topSort(ArrayList<Edge>[] graph){
        int[] indegree = new int[graph.length];
        calculateIndegree(graph, indegree);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int processedCount = 0;
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print( curr + " ");
            processedCount++; // Count processed vertices

            for(Edge e : graph[curr]){
                indegree[e.dest]--;
                if(indegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
        // If all vertices are not processed, the graph has a cycle.
        if (processedCount != graph.length) {
            System.out.println("The graph contains a cycle; topological sort is not possible.");
        }
    }


    public static void main2(){
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Create a DAG
        addEdge(graph, 2, 3, false);
        addEdge(graph, 3, 1, false);
        addEdge(graph, 4, 0, false);
        addEdge(graph, 4, 1, false);
        addEdge(graph, 5, 0, false);
        addEdge(graph, 5, 2, false);
 
        // Print the graph
        printGraph(graph);

        topologySort(graph);

        ArrayList<Edge>[] graph2 = new ArrayList[6];
        createGraph(graph2);
        topSort(graph2);
    }

    public static void main(String[] args) {
        main2();
    }

}
