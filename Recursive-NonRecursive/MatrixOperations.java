public class MatrixOperations {

    // ======= MATRIX ADDITION =======

    // Non-recursive matrix addition
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Recursive matrix addition
    public static int[][] addMatricesRecursive(int[][] A, int[][] B, int i, int j, int[][] result) {
        if (result == null) {
            result = new int[A.length][A[0].length];
        }
        if (i == A.length) {
            return result;
        }
        if (j == A[0].length) {
            return addMatricesRecursive(A, B, i + 1, 0, result);
        }
        result[i][j] = A[i][j] + B[i][j];
        return addMatricesRecursive(A, B, i, j + 1, result);
    }

    // ======= MATRIX MULTIPLICATION =======

    // Non-recursive matrix multiplication
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;
        int[][] result = new int[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // Recursive matrix multiplication
    public static int[][] multiplyMatricesRecursive(int[][] A, int[][] B, int i, int j, int k, int[][] result) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;

        if (result == null) {
            result = new int[m][p];
        }
        if (i == m) {
            return result;
        }
        if (j == p) {
            return multiplyMatricesRecursive(A, B, i + 1, 0, 0, result);
        }
        if (k < n) {
            result[i][j] += A[i][k] * B[k][j];
            return multiplyMatricesRecursive(A, B, i, j, k + 1, result);
        }
        return multiplyMatricesRecursive(A, B, i, j + 1, 0, result);
    }

    // ======= MATRIX TRANSPOSE =======

    // Non-recursive matrix transpose
    public static int[][] transposeMatrix(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    // Recursive matrix transpose
    public static int[][] transposeMatrixRecursive(int[][] A, int i, int j, int[][] result) {
        int rows = A.length;
        int cols = A[0].length;

        if (result == null) {
            result = new int[cols][rows];
        }
        if (i == rows) {
            return result;
        }
        if (j == cols) {
            return transposeMatrixRecursive(A, i + 1, 0, result);
        }
        result[j][i] = A[i][j];
        return transposeMatrixRecursive(A, i, j + 1, result);
    }

    // ======= UTILITY METHOD TO PRINT MATRIX =======
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // ======= MAIN METHOD TO TEST ALL =======
    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] B = {
            {7, 8, 9},
            {10, 11, 12}
        };
        int[][] C = {
            {1, 2},
            {3, 4},
            {5, 6}
        };

        System.out.println("Addition (Non-recursive):");
        printMatrix(addMatrices(A, B));

        System.out.println("Addition (Recursive):");
        printMatrix(addMatricesRecursive(A, B, 0, 0, null));

        System.out.println("Multiplication (Non-recursive):");
        printMatrix(multiplyMatrices(A, C));

        System.out.println("Multiplication (Recursive):");
        printMatrix(multiplyMatricesRecursive(A, C, 0, 0, 0, null));

        System.out.println("Transpose (Non-recursive):");
        printMatrix(transposeMatrix(A));

        System.out.println("Transpose (Recursive):");
        printMatrix(transposeMatrixRecursive(A, 0, 0, null));
    }
}
