import java.util.*;

public class magicSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int row_index = n - 1;
        int col_index = (n - 1) / 2;
        for (int i = 1; i <= n * n; i++) {
            arr[row_index][col_index] = i;
            row_index++;
            col_index--;
            if (i % n == 0) {
                row_index -= 2;
                col_index++;
            } else if (row_index == n) {
                row_index = 0;
            } else if (col_index == -1) {
                col_index = n - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();

    }
}
