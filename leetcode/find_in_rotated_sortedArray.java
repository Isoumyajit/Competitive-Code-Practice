import java.util.*;

public class find_in_rotated_sortedArray {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int target = s.nextInt();
        System.out.println(modified_binary(arr, target));
        s.close();
    }

    public static boolean modified_binary(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return true;

            else if ((arr[start] == arr[mid]) && (arr[end] == arr[mid])) {
                start++;
                end--;
            } else if (arr[mid] >= arr[start]) {
                if (target >= arr[start] && arr[mid] > target)
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if ((target <= arr[end]) && (target > arr[mid])) {
                    start = mid + 1;
                } else
                    end = mid - 1;
            }

        }
        return false;

    }
}
