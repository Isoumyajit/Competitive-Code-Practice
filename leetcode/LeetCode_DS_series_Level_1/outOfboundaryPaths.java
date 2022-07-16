public class outOfboundaryPaths {
    public static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    public static long md = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        if (maxMove == 0)
            return 0;
        Long[][][] visited = new Long[m + 1][n + 1][maxMove + 1];
        long answer = path(m, n, maxMove, 0, startRow, startColumn, visited);
        return (int) (answer % md);
    }

    private static long path(int m, int n, int max, int moves, int r, int c, Long[][][] visited) {

        if (moves > max)
            return 0;
        if (r < 0 || c < 0 || r == m || c == n)
            return 1;
        if (visited[r][c][moves] != null)
            return visited[r][c][moves];

        long totalPaths = 0;
        for (int[] directions : dirs) {
            totalPaths += path(m, n, max, moves + 1, r + directions[0], c + directions[1], visited) % md;
        }
        visited[r][c][moves] = totalPaths % md;
        return totalPaths;

    }
}