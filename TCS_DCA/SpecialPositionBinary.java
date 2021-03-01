import java.util.*;

public class SpecialPositionBinary {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int mat[][] = new int[n][n];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = s.nextInt();
            }
        }
        System.out.println(new SolutionCountPosition().numSpecial(mat));
        s.close();
    }
}

class SolutionCountPosition {
    public int numSpecial(int[][] mat) {
        int row[] = new int[mat.length];
        int col[] = new int[mat[0].length];
        int special_pos = 0;
        Arrays.fill(row, 0);
        Arrays.fill(col, 0);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (row[i] == 1 && col[j] == 1) {
                        special_pos++;
                    }
                }
            }
        }
        return special_pos;
    }
}