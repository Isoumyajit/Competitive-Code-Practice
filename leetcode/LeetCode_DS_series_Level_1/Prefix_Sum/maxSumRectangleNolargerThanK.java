package Prefix_Sum;

import java.util.TreeSet;

public class maxSumRectangleNolargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {

        int n = matrix[0].length;
        int m = matrix.length;
        TreeSet<Integer> set = new TreeSet<>();
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= k)
                    maxSum = Math.max(maxSum, matrix[i][j]);
            }
        }
        if (maxSum == k)
            return k;

        for (int row = 0; row < m; row++) {
            for (int col = 1; col < n; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }

        for (int c1 = 0; c1 < n; c1++) {
            for (int c2 = c1; c2 < n; c2++) {
                int sum = 0;
                set.clear();
                set.add(0);
                for (int row = 0; row < m; row++) {
                    sum += matrix[row][c2] - ((c1 > 0) ? matrix[row][c1 - 1] : 0);
                    int ind = set.ceiling(sum - k);
                    set.add(sum);
                    maxSum = Math.max(sum - ind, maxSum);
                    if (maxSum == k)
                        return k;
                }
            }
        }
        return maxSum;
    }
}
