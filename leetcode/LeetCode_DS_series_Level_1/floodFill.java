public class floodFill {
    private static int[][] dic = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] floodFill_(int[][] image, int sr, int sc, int color) {
        fillWithColor(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private static void fillWithColor(int[][] canvas, int row, int col, int color, int pixel) {
        if (row < 0 || row >= canvas.length || col < 0 || col >= canvas[0].length)
            return;
        if (canvas[row][col] == color)
            return;
        if (canvas[row][col] != pixel)
            return;
        canvas[row][col] = color;
        for (int[] dics : dic) {
            fillWithColor(canvas, row + dics[0], col + dics[1], color, pixel);
        }
    }
}