import java.util.*;

public class countInversions {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        s.close();
        System.out.println(new Solution_countInversion().findInversionCount(arr));
        // for (int i = 0; i < n; i++) {
        // System.out.print(arr[i] + " ");
        // }
    }
}

class Solution_countInversion {
    public long findInversionCount(long[] arr) {

        int len = arr.length - 1;
        return mergeSort(arr, 0, len);

    }

    public static long mergeSort(long[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            return mergeSort(arr, start, mid) + mergeSort(arr, mid + 1, end) + merge(arr, start, mid, mid + 1, end);
        }
        return 0;
    }

    public static long merge(long[] arr, int low1, int high1, int low2, int high2) {

        long[] temp = new long[high2 - low1 + 1];
        int l = low1;
        int l2 = low2;
        int k = 0;
        long inversionCount = 0;
        while (l <= high1 && l2 <= high2) {
            if (arr[l] <= arr[l2]) {
                temp[k++] = arr[l];
                l++;
            } else if (arr[l2] < arr[l]) {
                temp[k++] = arr[l2];
                l2++;
                inversionCount += (high1 - l + 1);
            }
        }
        while (l <= high1) {
            temp[k++] = arr[l++];
        }
        while (l2 <= high2) {
            temp[k++] = arr[l2++];
        }
        for (int i = low1, j = 0; i <= high2; i++) {
            arr[i] = temp[j++];
        }
        return inversionCount;
    }
}
