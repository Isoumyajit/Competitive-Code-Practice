import java.util.Arrays;
import java.util.Scanner;

public class nonOverlappingIntervals {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
        }
        System.out.println(Solution_nonOverlappingIntervals.eraseOverlapIntervals(matrix));
        sc.close();

    }
}

class Solution_nonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int last_included = 0;

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < intervals[last_included][1]) {
                count++;
                if (intervals[i][1] < intervals[last_included][1]) {
                    last_included = i;
                }
            } else {
                last_included = i;
            }
        }
        return count;
    }
}
