import java.util.*;

public class reverse_rows_matrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int temp = 0;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = s.nextInt();
            }
        }
        s.close();

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = matrix.length - 1, k = 0; j > k; j--, k++) {
                temp = matrix[k][i];
                matrix[k][i] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
