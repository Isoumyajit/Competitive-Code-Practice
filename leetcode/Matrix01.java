import java.util.*;

public class Matrix01 {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        s.close();

        // ......

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 1 + min(arr[i - 1][j], arr[i][j - 1], arr[i][j + 1], arr[i + 1][j]);
                }
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (arr[m - 1][i] == 1) {
                arr[m - 1][i] = 1 + minaux(arr[m - 1][i - 1], arr[m - 1][i + 1], arr[m - 2][i]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int min(int a, int b, int c, int d) {
        if (a < b && a < c && a < d)
            return a;
        else if (b < c && b < d)
            return b;
        else if (c < d)
            return c;
        return d;
    }

    public static int minaux(int a, int b, int c) {
        if (a < b && a < c)
            return a;
        else if (b < c)
            return b;
        return c;
    }
}
