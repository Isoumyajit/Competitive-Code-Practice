import java.util.Scanner;

public class rotateImage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        SolutionrotateImage.rotate(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();

    }
}

// Step 1 . Make transpose of the matrix in place
// Step 2 . Swap the transpose then from front side and back side

class SolutionrotateImage {
    public static void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                swap(matrix, i, j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0, j = matrix.length - 1; k < j; k++, j--) {
                matrix[i][k] = matrix[i][k] + matrix[i][j];
                matrix[i][j] = matrix[i][k] - matrix[i][j];
                matrix[i][k] = matrix[i][k] - matrix[i][j];
            }
        }
    }

    private static void swap(int[][] mat, int i, int j) {
        mat[i][j] = mat[i][j] + mat[j][i];
        mat[j][i] = mat[i][j] - mat[j][i];
        mat[i][j] = mat[i][j] - mat[j][i];
    }
}
