public class uniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 1)
            return 1;
        return getnThCatalan(n);
    }

    private static int getnThCatalan(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int j = 0;
            int k = i - 1;
            int sum = 0;
            while (j < k) {
                sum += 2 * dp[j] * dp[k];
                j++;
                k--;
            }
            if (j == k)
                sum += dp[j] * dp[k];
            dp[i] = sum;
        }
        return dp[n];

    }
}
