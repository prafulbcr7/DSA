package graph;

import java.util.*;

public class BiPartiteGraph {
    
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

    private static boolean isBipartite(ArrayList<Edge>[] graph){
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        color[0] = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(Edge e : graph[curr]){
                if(color[e.dest] == -1){ // not visited & not colored
                    color[e.dest] = 1- color[curr]; // asign opposite color
                    q.add(e.dest);
                }
                else{
                    if(color[curr] == color[e.dest]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void printList(List<Integer> list){
        for(int i : list){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void dfsHelper(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, List<Integer> currentPath, List<List<Integer>> paths) {
        // First mark as visited and add to path
        visited[src] = true;
        currentPath.add(src);

        // Then check if destination is reached
        if (src == dest) {
            paths.add(new ArrayList<>(currentPath));
            printList(currentPath);
        } else {
            // Explore neighbors only if destination not reached
            for (Edge e : graph[src]) {
                if (!visited[e.dest]) {
                    dfsHelper(graph, e.dest, dest, visited, currentPath, paths);
                }
            }
        }

        // Backtrack
        currentPath.remove(currentPath.size() - 1);
        visited[src] = false;
    }

    public static void printallPaths(ArrayList<Edge>[] graph, int src, int dest){
        boolean[] visited = new boolean[graph.length];
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfsHelper(graph, src, dest, visited, currentPath, paths);
    }

    static void addEdge(ArrayList<Edge>[] graph, int src, int dest, boolean isUnDirected){
        graph[src].add(new Edge(src, dest));
        if(isUnDirected)
            graph[dest].add(new Edge(dest, src));
    } 

    public static void main2(){
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Create a Undirected & bipartite graph
        addEdge(graph, 0, 1, true);
        addEdge(graph, 0, 2, true);
        //addEdge(graph, 0, 3, true);

        addEdge(graph, 1, 3, true);
        addEdge(graph, 2, 3, true);
 
        // Print the graph
        printGraph(graph);
        System.out.println("Is graph bipartite: " + isBipartite(graph));
        
        //Next graph
        ArrayList<Edge>[] graph1 = new ArrayList[6];
        for(int i = 0; i < 6; i++) {
            graph1[i] = new ArrayList<>();
        }

        addEdge(graph1, 0, 3, false);
        addEdge(graph1, 2, 3, false);
        addEdge(graph1, 3, 1, false);
        addEdge(graph1, 4, 0, false);
        addEdge(graph1, 4, 1, false);
        addEdge(graph1, 5, 0, false);
        addEdge(graph1, 5, 2, false);

        printGraph(graph1);
        printallPaths(graph1, 5, 1);

    }

    public static void main(String[] args) {
        main2();
    }
}
