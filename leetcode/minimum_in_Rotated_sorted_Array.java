import java.util.*;

public class minimum_in_Rotated_sorted_Array {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(arr[modified_binary(arr)]);
        s.close();
    }

    public static int modified_binary(int[] arr) {

        int index = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (start == end)
                return start;
            else if (arr[mid] == arr[start] && arr[end] == arr[mid]) {
                start++;
                end--;
            } else if (arr[mid] > arr[start]) {
                if (arr[start] < arr[end]) {
                    end = mid - 1;
                } else
                    start = mid + 1;
            } else if (arr[mid] > arr[end]) {
                if (arr[start] > arr[end]) {
                    start = mid + 1;
                } else
                    end = mid - 1;
            } else
                end--;
        }
        if (arr[start] == arr[end])
            return start;
        return index;
    }
}
