package Backtracking;

public class HamiltonianCycle {

    private int V;
    private int[] path;

    public HamiltonianCycle(int V) {
        this.V = V;
        path = new int[V];
        for (int i = 0; i < V; i++) {
            path[i] = -1;
        }
    }

    // Utility function to check if the vertex v can be added at position pos in the Hamiltonian Cycle
    private boolean isSafe(int v, int[][] graph, int[] path, int pos) {
        // Check if this vertex is adjacent to the previously added vertex
        if (graph[path[pos - 1]][v] == 0)
            return false;

        // Check if the vertex has already been included in the path
        for (int i = 0; i < pos; i++) {
            if (path[i] == v)
                return false;
        }

        return true;
    }

    // Recursive utility function to solve Hamiltonian Cycle problem
    private boolean hamCycleUtil(int[][] graph, int[] path, int pos) {
        // Base case: If all vertices are included in the path
        if (pos == V) {
            // And if there is an edge from the last included vertex to the first vertex
            return graph[path[pos - 1]][path[0]] == 1;
        }

        // Try different vertices as the next candidate in Hamiltonian Cycle
        for (int v = 1; v < V; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;

                if (hamCycleUtil(graph, path, pos + 1))
                    return true;

                // Backtracking
                path[pos] = -1;
            }
        }

        return false;
    }

    public boolean findHamiltonianCycle(int[][] graph) {
        path[0] = 0;  // Start from vertex 0

        if (!hamCycleUtil(graph, path, 1)) {
            System.out.println("No Hamiltonian Cycle exists");
            return false;
        }

        printSolution(path);
        return true;
    }

    private void printSolution(int[] path) {
        System.out.println("Hamiltonian Cycle exists:");
        for (int i = 0; i < V; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]);  // Print starting vertex again to show the cycle
    }

    public static void main(String[] args) {
        HamiltonianCycle hc = new HamiltonianCycle(5);

        int[][] graph1 = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        hc.findHamiltonianCycle(graph1);
    }
}
