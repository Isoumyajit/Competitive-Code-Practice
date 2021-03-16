import java.util.*;

public class Max_squareof1s {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int m, n;
        m = s.nextInt();
        n = s.nextInt();
        int arr[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        s.close();

        // .......
        int helper[][] = new int[m][n];
        for (int i = 0; i < n; i++) {
            helper[0][i] = arr[0][i];
        }
        for (int i = 1; i < m; i++) {
            helper[i][0] = arr[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 1) {
                    helper[i][j] = 1 + min(helper[i - 1][j - 1], helper[i - 1][j], helper[i][j - 1]);
                } else {
                    helper[i][j] = arr[i][j];
                }
            }
        }

        int max = 0, row = 0, col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (max < helper[i][j]) {
                    row = i;
                    col = j;
                    max = helper[i][j];
                }
            }
        }

        for (int i = row - (max - 1); i <= row; i++) {
            for (int j = col - (max - 1); j <= col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int min(int a, int b, int c) {
        if (a < b && a < c)
            return a;
        else if (b < c)
            return b;
        return c;
    }
}
