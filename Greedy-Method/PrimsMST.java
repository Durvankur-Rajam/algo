import java.util.Arrays;

public class PrimsMST {

    private static final int INF = Integer.MAX_VALUE;

    // Function to find the vertex with minimum key value
    int minKey(int[] key, boolean[] mstSet, int V) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < V; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        return minIndex;
    }

    // Function to print the MST
    void printMST(int[] parent, int[][] graph, int V) {
        int totalCost = 0;
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalCost += graph[i][parent[i]];
        }
        System.out.println("Total Cost: " + totalCost);
    }

    // Function to construct MST using Prim's Algorithm
    void primMST(int[][] graph, int V) {
        int[] parent = new int[V]; // MST result
        int[] key = new int[V]; // Weight values
        boolean[] mstSet = new boolean[V]; // Set of vertices in MST

        Arrays.fill(key, INF);
        key[0] = 0; // Start from vertex 0
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet, V);
            mstSet[u] = true;

            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        printMST(parent, graph, V);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        int V = graph.length;
        PrimsMST mst = new PrimsMST();
        mst.primMST(graph, V);
    }
}
