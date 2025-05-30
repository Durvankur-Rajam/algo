import java.util.*;

public class DijkstrasAlgorithm {

    // Number of vertices
    static final int V = 9;

    // Function to find the vertex with the minimum distance value
    int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++)
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }

        return minIndex;
    }

    // Function that implements Dijkstra's algorithm for a graph represented using adjacency matrix
    void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V];          // Output array: shortest distance from src to i
        boolean[] visited = new boolean[V]; // visited[i] is true if vertex i's shortest distance is finalized

        // Initialize all distances as INFINITE and visited[] as false
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // Distance of source vertex from itself is always 0

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);

            visited[u] = true;

            // Update distance value of the adjacent vertices of the picked vertex
            for (int v = 0; v < V; v++) {
                if (!visited[v] &&
                    graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print the constructed distance array
        printSolution(dist, src);
    }

    void printSolution(int[] dist, int src) {
        System.out.println("Vertex\t\tDistance from Source " + src);
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dist[i]);
    }

    // Main method
    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        DijkstrasAlgorithm da = new DijkstrasAlgorithm();
        da.dijkstra(graph, 0); // Source vertex is 0
    }
}
