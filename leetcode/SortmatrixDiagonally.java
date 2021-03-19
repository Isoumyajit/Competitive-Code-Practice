import java.util.*;

public class SortmatrixDiagonally {
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

        // ....Sort the mateix diagonally

        PriorityQueue<Integer> helper = new PriorityQueue<Integer>();

        for (int i = m - 1; i > 0; i--) {
            int row = i;
            int col = 0;
            for (int j = 0, k = i; k < m && j < n; j++, k++) {
                helper.add(arr[k][j]);
            }
            while (!helper.isEmpty()) {
                arr[row++][col++] = helper.poll();
            }
        }
        for (int j = 0; j < n; j++) {
            int row = 0;
            int col = j;
            for (int i = 0, k = j; k < n && i < m; i++, k++) {
                helper.add(arr[i][k]);
            }
            while (!helper.isEmpty()) {
                arr[row++][col++] = helper.poll();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
