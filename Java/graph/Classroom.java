package graph;

import java.util.*;

public class Classroom {

    public static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){

        // Initialize all vertices with empty ArrayLists
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges (assuming undirected graph)
        //0 -> vertex  
        graph[0].add(new Edge(0, 1, 5));

        //1 -> vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        //2-> vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        //3-> vertex
        graph[3].add(new Edge(3,2,1));
        graph[3].add(new Edge(3,1,3));

        //4-> vertex
        graph[4].add(new Edge(4,2,2));
    }

    // Graph - 2
    public static void createGraph2(ArrayList<Edge>[] graph){

        // Initialize all vertices with empty ArrayLists
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges (assuming undirected graph)
        //0 -> vertex  
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        //1 -> vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        //2-> vertex
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        //3-> vertex
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3, 5, 1));

        //4-> vertex
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        //5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        //6
        graph[6].add(new Edge(6, 5, 1));

    }

    public static void bfsTraversal(ArrayList<Edge>[] graph){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        // traversal starts with 0 vertex
        queue.add(0);

        while(!queue.isEmpty()){
            int currentVertex = queue.remove();

            if(!visited[currentVertex]){
                System.out.print(currentVertex + " ");
                visited[currentVertex] = true;
                
                // add currentVertex's neighbours to queue
                for(int i=0; i<graph[currentVertex].size(); i++){
                    Edge e = graph[currentVertex].get(i);
                    queue.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited){

        //visit the current vertex
        System.out.print(curr + " ");
        visited[curr] = true;

        for(int i=0;i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        // implementing using DFS method
        if(src == dest){
            return true;
        }

        visited[src] = true;
        for(int i=0; i< graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V]; // by default null
        boolean[] visited = new boolean[V];

        //createGraph(graph);
        createGraph2(graph);

        System.out.println("BFS Traversal : ");
        bfsTraversal(graph);
        System.out.println();

        //Print the neighbours of each vertex
        System.out.println("DFS Traversal : ");
        dfs(graph, 0, visited);
        System.out.println();


        //Check if there is a path between 0 and 5
        System.out.println("Path between 0 and 5 : " + hasPath(graph, 0, 5, new boolean[V]));
        System.out.println("Path between 0 and 7 : " + hasPath(graph, 0, 7, new boolean[V]));
        System.out.println();
        
        //Print the neightbours of each vertex
        System.out.println("Printing neighbours of each vertex : ");
        for(int i=0; i<V; i++){
            System.out.print(i + " -> ");
            for(Edge e : graph[i]){
                System.out.print("[" + e.dest + "@" + e.wt + "], ");
            }
            System.out.println();
        }

        //Print graph
        System.out.println("Graph : " + Arrays.toString(graph));

        //Print neighbours of vertex 2
        for(int i=0; i< graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest + " with weight " + e.wt);
        }


    }
}