package Backtracking;

import java.util.Arrays;

public class TSBranchAndBound {
    private int N;
    private int[][] dist;
    private boolean[] visited;
    private int finalRes = Integer.MAX_VALUE;
    private int[] finalPath;

    public TSBranchAndBound(int[][] dist) {
        this.dist = dist;
        this.N = dist.length;
        this.visited = new boolean[N];
        this.finalPath = new int[N + 1];
    }

    // Function to find the minimum edge cost having an end at the vertex i
    private int firstMin(int i) {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < N; k++) {
            if (dist[i][k] < min && i != k)
                min = dist[i][k];
        }
        return min;
    }

    // Function to find the second minimum edge cost having an end at the vertex i
    private int secondMin(int i) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int j = 0; j < N; j++) {
            if (i == j)
                continue;

            if (dist[i][j] <= first) {
                second = first;
                first = dist[i][j];
            } else if (dist[i][j] <= second && dist[i][j] != first) {
                second = dist[i][j];
            }
        }
        return second;
    }

    private void TSPRec(int currBound, int currWeight, int level, int[] currPath) {
        // Base case: all vertices are visited
        if (level == N) {
            // Check if there is an edge from last vertex in path back to the first vertex
            if (dist[currPath[level - 1]][currPath[0]] != 0) {
                int currRes = currWeight + dist[currPath[level - 1]][currPath[0]];
                if (currRes < finalRes) {
                    finalPath = Arrays.copyOf(currPath, N + 1);
                    finalPath[N] = currPath[0];
                    finalRes = currRes;
                }
            }
            return;
        }

        // Iterate through all vertices to build the search tree recursively
        for (int i = 0; i < N; i++) {
            if (dist[currPath[level - 1]][i] != 0 && !visited[i]) {
                int temp = currBound;
                currWeight += dist[currPath[level - 1]][i];

                // Different computation of currBound for level 1 and others
                if (level == 1)
                    currBound -= ((firstMin(currPath[level - 1]) + firstMin(i)) / 2);
                else
                    currBound -= ((secondMin(currPath[level - 1]) + firstMin(i)) / 2);

                // Prune the branch if current bound + weight is less than final result
                if (currBound + currWeight < finalRes) {
                    currPath[level] = i;
                    visited[i] = true;

                    TSPRec(currBound, currWeight, level + 1, currPath);
                }

                // Backtrack
                currWeight -= dist[currPath[level - 1]][i];
                currBound = temp;

                Arrays.fill(visited, false);
                for (int j = 0; j < level; j++) {
                    visited[currPath[j]] = true;
                }
            }
        }
    }

    public void solve() {
        int[] currPath = new int[N + 1];
        int currBound = 0;

        // Compute initial bound
        for (int i = 0; i < N; i++) {
            currBound += (firstMin(i) + secondMin(i));
        }

        // Rounding off the lower bound to an integer
        currBound = (currBound % 2 == 1) ? (currBound / 2) + 1 : currBound / 2;

        // Start from vertex 0
        visited[0] = true;
        currPath[0] = 0;

        TSPRec(currBound, 0, 1, currPath);

        printSolution();
    }

    private void printSolution() {
        System.out.println("Minimum cost : " + finalRes);
        System.out.print("Path Taken : ");
        for (int i = 0; i <= N; i++) {
            System.out.print(finalPath[i] + (i == N ? "\n" : " -> "));
        }
    }

    public static void main(String[] args) {
        int[][] dist = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        TSBranchAndBound tsp = new TSBranchAndBound(dist);
        tsp.solve();
    }
}
