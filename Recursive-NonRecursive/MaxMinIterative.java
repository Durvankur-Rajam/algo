
public class MaxMinIterative {
    public static void main(String[] args) {
        int[] arr = {12, 45, 2, 67, 33, 5, 89};

        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }

        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }
}

//---------------------------------------------------

// public class MaxMinRecursive {

//     public static int findMax(int[] arr, int n) {
//         if (n == 1)
//             return arr[0];
//         return Math.max(arr[n - 1], findMax(arr, n - 1));
//     }

//     public static int findMin(int[] arr, int n) {
//         if (n == 1)
//             return arr[0];
//         return Math.min(arr[n - 1], findMin(arr, n - 1));
//     }

//     public static void main(String[] args) {
//         int[] arr = {12, 45, 2, 67, 33, 5, 89};

//         int max = findMax(arr, arr.length);
//         int min = findMin(arr, arr.length);

//         System.out.println("Maximum value: " + max);
//         System.out.println("Minimum value: " + min);
//     }
// }
