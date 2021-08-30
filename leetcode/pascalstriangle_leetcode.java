import java.util.*;

public class pascalstriangle_leetcode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[][] mat = new int[n][n];
        // int k = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    mat[i][j] = 1;
                } else if (j == i) {
                    mat[i][j] = 1;
                    break;
                } else {
                    mat[i][j] = mat[i - 1][j - 1] + mat[i - 1][j];
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                temp.add(mat[i][j]);
            }
            result.add(temp);
        }
        System.out.println(result);
    }
}
