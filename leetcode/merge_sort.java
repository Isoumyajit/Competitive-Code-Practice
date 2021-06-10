import java.util.*;

public class merge_sort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        selection_sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        s.close();
    }

    public static void merge(int[] arr, int a, int b) {
        if (a < b) {
            int mid = (a + b) / 2;
            merge(arr, a, mid);
            merge(arr, mid + 1, b);
            sort(arr, a, mid, mid + 1, b);
        }
    }

    public static void sort(int[] arr, int low, int high, int low1, int high1) {
        int length = high - low + 1;
        int length2 = high1 - low1 + 1;
        int x = low;
        int y = low1;
        int k = 0;
        int[] temp1 = new int[length + length2];
        while (x <= high && y <= high1) {
            if (arr[x] < arr[y]) {
                temp1[k++] = arr[x];
                x++;
            } else {
                temp1[k++] = arr[y];
                y++;
            }
        }
        while (x <= high) {
            temp1[k++] = arr[x++];
        }
        while (y <= high1) {
            temp1[k++] = arr[y++];
        }
        for (int i = 0, j = low; j <= high1; j++) {
            arr[j] = temp1[i++];
        }
    }

    public static void quick(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = find_pivot(arr, low, high);
            System.out.println(pivot);
            quick(arr, low, pivot - 1);
            quick(arr, pivot + 1, high);
        }
    }

    public static int find_pivot(int[] arr, int low, int high) {

        int l, r;
        l = low;
        r = high + 1;
        int pivot = arr[low];
        do {
            do {
                l++;
            } while (l < high && arr[l] < pivot);
            do {
                r--;
            } while (arr[r] > pivot);
            if (l < r) {
                arr[l] = arr[l] + arr[r];
                arr[r] = arr[l] - arr[r];
                arr[l] = arr[l] - arr[r];
            }
        } while (l < r);
        arr[low] = arr[r];
        arr[r] = pivot;
        return r;
    }

    public static void insertion_sort(int[] arr) {

        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = i - 1;
            int k = i;
            temp[i] = arr[k];
            while (j >= 0 && temp[j] > temp[k]) {
                temp[k] = temp[j] + temp[k];
                temp[j] = temp[k] - temp[j];
                temp[k] = temp[k] - temp[j];
                j--;
                k--;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }

    public static void selection_sort(int[] arr) {

        int minIndex = -1, j = 0, i = 0, min = Integer.MAX_VALUE;
        for (i = 0; i < arr.length; i++) {
            for (j = i + 1; j < arr.length; j++) {
                if (min >= arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            min = Integer.MAX_VALUE;
            if (i != minIndex && arr[i] > arr[minIndex]) {
                arr[i] += arr[minIndex];
                arr[minIndex] = arr[i] - arr[minIndex];
                arr[i] = arr[i] - arr[minIndex];
            }
        }
    }
}