public class FactorialRecursive {

    // Recursive function to calculate factorial
    public static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int number = 5; // Change this number as needed
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }
}

// ---------------------------------------------------------


// public class FactorialIterative {

//     public static void main(String[] args) {
//         int number = 5; // Change this number as needed
//         int factorial = 1;

//         for (int i = 1; i <= number; i++) {
//             factorial *= i;
//         }

//         System.out.println("Factorial of " + number + " is: " + factorial);
//     }
// }
