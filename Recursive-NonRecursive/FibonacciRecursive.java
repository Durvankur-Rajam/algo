public class FibonacciRecursive {

    // Recursive function to return nth Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10; // Number of terms
        System.out.println("Fibonacci Series (Recursive):");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
 
//---------------------------------------------------------

// public class FibonacciIterative {

//     public static void main(String[] args) {
//         int n = 10; // Number of terms
//         int a = 0, b = 1;

//         System.out.println("Fibonacci Series (Non-Recursive):");
//         for (int i = 0; i < n; i++) {
//             System.out.print(a + " ");
//             int next = a + b;
//             a = b;
//             b = next;
//         }
//     }
// }
