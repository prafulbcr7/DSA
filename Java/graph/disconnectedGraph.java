package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graph.Classroom.Edge;

public class disconnectedGraph {
    
    public static void dfsHelper(ArrayList<Edge>[] graph, int curr, boolean[] visited){

        //visit the current vertex
        System.out.print(curr + " ");
        visited[curr] = true;

        for(int i=0;i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfsHelper(graph, e.dest, visited);
            }
        }
    }


    // The dfs function that handles disconnected graphs
    public static void dfs(ArrayList<Edge>[] graph) {
        int n = graph.length; // Number of vertices in the graph
        boolean[] visited = new boolean[n];

        // Start DFS from every vertex if it's unvisited
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsHelper(graph, i, visited);  // Start DFS from this unvisited node
            }
        }
    }


        // BFS helper function to perform BFS from a given start vertex
    public static void bfsHelper(ArrayList<Edge>[] graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();
            System.out.print(currentVertex + " ");

            // Add currentVertex's neighbors to the queue
            for (int i = 0; i < graph[currentVertex].size(); i++) {
                Edge e = graph[currentVertex].get(i);
                if (!visited[e.dest]) {
                    queue.add(e.dest);
                    visited[e.dest] = true; // Mark as visited when added to queue
                }
            }
        }
    }

    // Main BFS traversal function that handles disconnected components
    public static void bfsTraversal(ArrayList<Edge>[] graph) {
        int n = graph.length; // Number of vertices in the graph
        boolean[] visited = new boolean[n];

        // Start BFS from every vertex if it's unvisited
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfsHelper(graph, i, visited);  // Start BFS from this unvisited node
                System.out.print("\n"); // New line after BFS for each component
            }
        }
    }

}
