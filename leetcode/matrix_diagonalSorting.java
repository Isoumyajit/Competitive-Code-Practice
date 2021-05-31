import java.util.*;

public class matrix_diagonalSorting {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.nextInt();
            }
        }

        ArrayList<Integer> helper = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int col = i;
            for (int j = 0; j < m; j++) {
                helper.add(arr[j][col]);
                col += 1;
                if (col >= n) {
                    break;
                }
            }
            Collections.sort(helper);
            col = i;
            for (int j = 0; j < m; j++) {
                arr[j][col] = helper.get(0);
                helper.remove(0);
                col += 1;
                if (col >= n) {
                    break;
                }
            }
            helper.clear();
        }

        for (int i = 1; i < m; i++) {
            int col = i;
            for (int j = 0; j < n; j++) {
                helper.add(arr[col][j]);
                col += 1;
                if (col >= m)
                    break;
            }
            Collections.sort(helper);
            col = i;
            for (int j = 0; j < n; j++) {
                arr[col][j] = helper.get(0);
                helper.remove(0);
                col += 1;
                if (col >= m) {
                    break;
                }
            }
            helper.clear();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        s.close();
    }
}
