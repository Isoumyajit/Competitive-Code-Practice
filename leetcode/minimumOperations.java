import java.util.*;

public class minimumOperations {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        String str2 = s.nextLine();

        int len1 = str1.length() + 1;
        int len2 = str2.length() + 1;

        int[][] mat = new int[len1][len2];

        mat[0][0] = 0;
        for (int i = 1; i < len2; i++) {
            mat[0][i] = mat[0][i - 1] + 1;
        }
        for (int i = 1; i < len1; i++) {
            mat[i][0] = mat[i - 1][0] + 1;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {

                if (str1.charAt(i - 1) != str2.charAt(j - 1)) {

                    mat[i][j] = Math.min(mat[i - 1][j - 1], mat[i][j - 1]);
                    mat[i][j] = Math.min(mat[i - 1][j], mat[i][j]) + 1;
                } else {
                    mat[i][j] = mat[i - 1][j - 1];
                }

            }
        }
        System.out.println(mat[len1 - 1][len2 - 1]);
        s.close();
    }
}
