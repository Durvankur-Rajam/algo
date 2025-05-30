public class MatrixChainMultiplication {

    // Function to find minimum number of multiplications needed to multiply matrices
    static int matrixChainOrder(int[] dims) {
        int n = dims.length - 1;  // Number of matrices
        int[][] dp = new int[n][n];

        // dp[i][j] = minimum number of scalar multiplications needed to compute the matrix A[i]...A[j]

        // cost is zero when multiplying one matrix
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        // l is chain length
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    // q = cost/scalar multiplications
                    int q = dp[i][k] + dp[k + 1][j] + dims[i] * dims[k + 1] * dims[j + 1];
                    if (q < dp[i][j]) {
                        dp[i][j] = q;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        // Dimensions array: for matrices A1: 10x30, A2: 30x5, A3: 5x60
        int[] dims = {10, 30, 5, 60};

        int result = matrixChainOrder(dims);
        System.out.println("Minimum number of multiplications is " + result);
    }
}
