import java.util.*;

public class ShortestSubArrayToBeRemoved {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        s.close();
        // ......

        int i, j;
        for (i = 0; i < arr.length - 1;) {
            if (arr[i] <= arr[i + 1]) {
                i++;
            }
        }
        for (j = arr.length - 1; j > i;) {
            if (arr[j] >= arr[j - 1]) {
                j--;
            }
        }
        if (i == 0 && j == 0)
            System.out.println(0);
        if ((i == 0 && j == arr.length - 1)) {
            if (arr[i] <= arr[j])
                System.out.println(arr.length - 2);
            else
                System.out.println(arr.length - 1);
        }
        int right = 0, left = j, answer = Math.min(arr.length - i - 1, j);
        while (right <= i && left <= arr.length - 1) {
            if (arr[right] <= arr[left]) {
                answer = Math.min(answer, left - right - 1);
                left++;
            } else {
                right++;
            }
        }
        System.out.println(answer);
    }
}
