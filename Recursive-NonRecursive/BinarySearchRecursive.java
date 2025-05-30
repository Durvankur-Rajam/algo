public class BinarySearchRecursive {

    // Recursive binary search method
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right)
            return -1; // Not found

        int mid = left + (right - left) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            return binarySearch(arr, target, mid + 1, right);
        else
            return binarySearch(arr, target, left, mid - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;

        int index = binarySearch(arr, target, 0, arr.length - 1);
        if (index != -1)
            System.out.println("Recursive: Element " + target + " found at index: " + index);
        else
            System.out.println("Recursive: Element " + target + " not found.");
    }
}

// ------------------------------------------------------------------

// public class BinarySearchNonRecursive {

//     // Non-recursive binary search method
//     public static int binarySearch(int[] arr, int target) {
//         int left = 0, right = arr.length - 1;

//         while (left <= right) {
//             int mid = left + (right - left) / 2;

//             if (arr[mid] == target)
//                 return mid;
//             else if (arr[mid] < target)
//                 left = mid + 1;
//             else
//                 right = mid - 1;
//         }

//         return -1; // Not found
//     }

//     public static void main(String[] args) {
//         int[] arr = {1, 3, 5, 7, 9, 11, 13};
//         int target = 7;

//         int index = binarySearch(arr, target);
//         if (index != -1)
//             System.out.println("Non-recursive: Element " + target + " found at index: " + index);
//         else
//             System.out.println("Non-recursive: Element " + target + " not found.");
//     }
// }
