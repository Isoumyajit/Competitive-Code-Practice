package Dynamic_Programming;

public class whereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] dp = new Integer[m + 5][n + 5];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = fillWithDFS(grid, dp, 0, i);
        }
        return ans;
    }

    private static boolean isValid(int r, int c, int[][] grid) {
        return (r < grid.length && c >= 0 && r >= 0 && c < grid[0].length);
    }

    private static int fillWithDFS(int[][] grid, Integer[][] dp, int row, int col) {

        if (row == grid.length)
            return col;
        if (isValid(row, col + 1, grid) && grid[row][col] == 1 && grid[row][col + 1] == 1) {
            if (dp[row + 1][col + 1] != null)
                return dp[row + 1][col + 1];
            else
                return dp[row + 1][col + 1] = fillWithDFS(grid, dp, row + 1, col + 1);
        } else if (isValid(row, col - 1, grid) && grid[row][col] == -1 && grid[row][col - 1] == -1) {
            if (dp[row + 1][col - 1] != null)
                return dp[row + 1][col - 1];
            else
                return dp[row + 1][col - 1] = fillWithDFS(grid, dp, row + 1, col - 1);
        } else
            return -1;
    }
}
