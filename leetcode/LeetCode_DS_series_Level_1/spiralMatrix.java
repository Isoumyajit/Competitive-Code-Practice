import java.util.Scanner;

public class spiralMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int row_counter = 0;
        int col_counter = 0;
        int row_index = n;
        int col_index = m;

        while (row_counter < row_index && col_counter < col_index) {
            for (int i = col_counter; i < col_index; i++) {
                System.out.print(matrix[row_counter][i] + " ");
            }
            row_counter++;
            for (int i = row_counter; i < row_index; i++) {
                System.out.print(matrix[i][col_index - 1] + " ");
            }
            col_index--;
            for (int i = col_index - 1; i >= col_counter; i--) {
                System.out.print(matrix[row_index - 1][i] + " ");
            }
            row_index--;
            for (int i = row_index - 1; i >= row_counter; i--) {
                System.out.print(matrix[i][col_counter] + " ");
            }
            col_counter++;
        }
        sc.close();
    }
}
