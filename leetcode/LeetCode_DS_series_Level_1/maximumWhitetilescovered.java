
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class maximumWhitetilescovered {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
        }
        int carPetLength = sc.nextInt();
        System.out.println(maximumLength.maximumLengthOfCarpet(matrix, carPetLength));
        sc.close();
    }
}

class maximumLength {

    public static int maximumLengthOfCarpet(int[][] mat, int carpetLen) {

        List<List<Integer>> helper = new LinkedList<>();
        int start = mat[0][0];
        int end = mat[0][1];
        int answer = 0;
        for (int row = 1; row < mat.length; row++) {

            if (end + 1 >= mat[row][0]) {
                end = Math.max(end, mat[row][1]);
            } else {
                helper.add(Arrays.asList(start, end));
                start = mat[row][0];
                end = mat[row][1];
            }
        }

        int max_diff = Integer.MAX_VALUE;
        for (int index = 0; index < helper.size(); index++) {
            int diff = helper.get(index).get(1) - helper.get(index).get(0) + 1;
            if (max_diff > carpetLen - diff) {
                max_diff = carpetLen - diff;
                answer = diff;
            }

        }
        return answer;
    }

}
