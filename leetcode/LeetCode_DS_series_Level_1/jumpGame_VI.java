import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class jumpGame_VI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        int[] arr = new int[] { 1, -5, -20, 4, -1, 3, -6, -3, 90, 98, 764, 7844, 5849, 7464, 7636, 443, 8464, 7647 };

        int k = 6;
        System.out.println(maxResult(arr, k));
        sc.close();
    }

    public static int maxResult(int[] nums, int k) {

        if (nums.length == 1)
            return nums[0];
        int n = nums.length;
        // int a = maxRes(nums, n, 0, k, 0);
        int a = maxResIterative(nums, n, k);
        return a;

    }

    public static int maxRes(int[] arr, int n, int index, int k, int cost) {
        if (index == n)
            return cost;
        int res = Integer.MIN_VALUE;
        for (int i = index; i < n; i++) {
            res = Math.max(res, maxRes(arr, n, i + 1, k, cost + arr[i]));
        }
        return res;
    }

    public static int maxResIterative(int[] arr, int n, int k) {

        int cnt = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(0);
        for (int index = 1; index < n; index++) {
            arr[index] += arr[dq.peekFirst()];
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[index]) {
                dq.pollLast();
            }
            dq.addLast(index);
            while (!dq.isEmpty() && dq.peekFirst() + k <= index) {
                dq.pollFirst();
            }
        }
        return arr[n - 1];
    }
}