public class SumOddEvenIterative {

    public static void main(String[] args) {
        int n = 5; // Number of terms

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 1; i <= n; i++) {
            evenSum += 2 * i;      // Even numbers: 2, 4, 6, ...
            oddSum += 2 * i - 1;   // Odd numbers: 1, 3, 5, ...
        }

        System.out.println("Sum of first " + n + " even numbers: " + evenSum);
        System.out.println("Sum of first " + n + " odd numbers: " + oddSum);
    }
}



// --------------------------------------------------------


// public class SumOddEvenRecursive {

//     public static int sumEven(int n) {
//         if (n == 0) return 0;
//         return 2 * n + sumEven(n - 1);
//     }

//     public static int sumOdd(int n) {
//         if (n == 0) return 0;
//         return (2 * n - 1) + sumOdd(n - 1);
//     }

//     public static void main(String[] args) {
//         int n = 5; // Number of terms

//         System.out.println("Sum of first " + n + " even numbers: " + sumEven(n));
//         System.out.println("Sum of first " + n + " odd numbers: " + sumOdd(n));
//     }
// }
