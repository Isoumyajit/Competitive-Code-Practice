import java.util.*;

public class heap_sort {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        s.close();
    }

    public static void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int leftchild = 2 * i + 1;
        int rightchild = leftchild + 1;
        if (leftchild < n && arr[leftchild] > arr[largest]) {
            largest = leftchild;
        }
        if (rightchild < n && arr[rightchild] > arr[largest]) {
            largest = rightchild;
        }
        if (i != largest) {
            swap(arr, i, largest);
            maxHeapify(arr, n, largest);
        }
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, i, 0);
            maxHeapify(arr, i, 0);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] += arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }
}
