import java.util.*;

public class maximumSumafterKconcat {

    public static long maxSubSumKConcat(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.

        long totalSum = getSum(arr);
        if (k > 1)
            for (int i = 0, j = 0; i < n; i++, j++) {
                arr.add(arr.get(j));
            }
        if (totalSum > 0) {
            long maxSum = kadane(arr);
            if (k > 2)
                maxSum += (k - 2) * totalSum;
            return maxSum;
        } else {
            long maxSum = kadane(arr);
            return maxSum;
        }
    }

    private static long kadane(ArrayList<Integer> arr) {
        long maxSum = Long.MIN_VALUE;
        long runningSum = 0;
        for (int a : arr) {
            runningSum += a;
            if (runningSum < a)
                runningSum = a;
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }

    private static long getSum(ArrayList<Integer> arr) {
        long sum = 0;
        for (int a : arr)
            sum += a;
        return sum;
    }
}