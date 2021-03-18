import java.util.*;

public class MaximumSumSubmatrix {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();

        // ......

    }

    public static int kadane(int matrix[]) {
        int maxsum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i];
            if (matrix[i] < sum) {
                matrix[i] = sum;
            } else {
                sum = matrix[i];
            }

            maxsum = Math.max(maxsum, sum);
        }
        return maxsum;
    }
}
