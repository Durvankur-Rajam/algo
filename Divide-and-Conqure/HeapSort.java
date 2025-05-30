
public class HeapSort {

    // Function to build a max heap from the array
    public static void buildMaxHeap(int[] arr, int n) {
        // Start from the last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // Heapify subtree rooted at index i for heap size n
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;      // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2;// right child

        // If left child exists and is greater than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child exists and is greater than current largest
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Main function to do heap sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        buildMaxHeap(arr, n);

        // One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    // Driver method to test above functions
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Given array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
