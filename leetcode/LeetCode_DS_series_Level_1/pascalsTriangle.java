import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pascalsTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowIndex = sc.nextInt();
        System.out.println(SolutionpascalTriangle.getRow(rowIndex));
        sc.close();

    }
}

class SolutionpascalTriangle {
    public static List<Integer> getRow(int rowIndex) {

        int[][] helper = new int[rowIndex + 1][rowIndex + 1];
        for (int row_counter = 0; row_counter < rowIndex + 1; row_counter++) {
            for (int column_counter = 0; column_counter < row_counter + 1; column_counter++) {
                if (column_counter == 0 || column_counter == row_counter) {
                    helper[row_counter][column_counter] = 1;
                } else {
                    helper[row_counter][column_counter] = helper[row_counter - 1][column_counter - 1]
                            + helper[row_counter - 1][column_counter];
                }
            }
        }
        List<Integer> answer = new ArrayList<Integer>();
        for (int row = rowIndex, col = 0; col < rowIndex + 1; col++) {
            answer.add(helper[row][col]);
        }
        return answer;
    }
}