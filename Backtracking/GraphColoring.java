package Backtracking;

public class GraphColoring {

    private int V;  // Number of vertices
    private int[] colors;  // Array to store colors assigned to vertices

    // Function to check if the current color assignment is safe for vertex v
    private boolean isSafe(int v, int[] graph[], int[] colors, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && colors[i] == c) {
                return false;  // Adjacent vertex has the same color
            }
        }
        return true;
    }

    // Recursive utility function to solve the graph coloring problem
    private boolean graphColoringUtil(int[] graph[], int m, int colors[], int v) {
        if (v == V)  // All vertices are assigned a color
            return true;

        // Try assigning each color from 1 to m
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, colors, c)) {
                colors[v] = c;

                if (graphColoringUtil(graph, m, colors, v + 1))
                    return true;

                // Backtrack
                colors[v] = 0;
            }
        }
        return false;  // No color can be assigned to this vertex
    }

    // Main function to solve the graph coloring problem
    public boolean graphColoring(int[] graph[], int m) {
        colors = new int[V];
        for (int i = 0; i < V; i++) {
            colors[i] = 0;
        }

        if (!graphColoringUtil(graph, m, colors, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(colors);
        return true;
    }

    // Function to print the color assignments
    private void printSolution(int[] colors) {
        System.out.println("Solution Exists: Following are the assigned colors:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " --> Color " + colors[i]);
        }
    }

    public static void main(String[] args) {
        GraphColoring gc = new GraphColoring();

        /*
        Example graph (Adjacency matrix representation):

        (0)--(1)
         |   / |
         |  /  |
        (2)---(3)
        */

        int graph[][] = {
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0},
        };

        gc.V = graph.length;
        int m = 3;  // Number of colors

        gc.graphColoring(graph, m);
    }
}
