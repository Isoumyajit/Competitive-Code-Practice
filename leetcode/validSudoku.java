import java.util.*;

public class validSudoku {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // List<List<Integer>> temp2 = new ArrayList<List<Integer>>();
        int n = sc.nextInt();
        int[][] sudo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sudo[i][j] = sc.nextInt();
            }
        }

        HashSet<String> helper = new HashSet<String>();
        for (int i = 0; i < sudo.length; i++) {
            for (int j = 0; j < sudo[i].length; j++) {
                if (!helper.add("row" + i + sudo[i][j]) || !helper.add("col" + j + sudo[i][j])) {
                    System.out.print(false);
                    System.exit(0);
                }
                if (!helper.add("box" + (i / 3) * j / 3 + sudo[i][j])) {
                    System.out.print(false);
                    System.exit(0);
                }
            }
        }
        System.out.print(true);
        sc.close();
    }
}
