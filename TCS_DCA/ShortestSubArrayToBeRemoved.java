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
        Stack<Integer> helper = new Stack<Integer>();
        Stack<Integer> subarray = new Stack<Integer>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                helper.push(i);
            } else {
                if (!helper.isEmpty() && arr[helper.peek()] >= arr[i]) {
                    helper.push(i);
                } else {
                    subarray.push(arr[i]);
                }
            }
        }
    }
}
