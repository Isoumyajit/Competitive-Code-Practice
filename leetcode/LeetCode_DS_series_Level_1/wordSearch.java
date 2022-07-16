public class wordSearch {
    public boolean exist(char[][] board, String word) {

        int len = word.length();
        if (len == 0)
            return true;
        if (board.length == 1) {
            if (len > board.length)
                return false;
            else if (board[0][0] == word.charAt(0))
                return true;
        }

        int row = board.length;
        int col = board[0].length;

        boolean visited[][] = new boolean[row][col];
        for (int index = 0; index < row; index++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[index][j] && !visited[index][j]) {
                    if (findWord(board, word, 0, index, j, visited, len))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean findWord(char[][] arr, String word, int index, int row, int col, boolean[][] visited,
            int len) {

        if (index == len - 1)
            return true;
        if (row < 0 || col < 0 || row == arr.length || col == arr[0].length || visited[row][col])
            return false;

        if (word.charAt(index) == arr[row][col]) {
            visited[row][col] = true;
            if (findWord(arr, word, index + 1, row + 1, col, visited, len)
                    | findWord(arr, word, index + 1, row - 1, col, visited, len)
                    | findWord(arr, word, index + 1, row, col - 1, visited, len)
                    | findWord(arr, word, index + 1, row, col + 1, visited, len))
                return true;
            visited[row][col] = false;
        }
        return false;
    }
}
