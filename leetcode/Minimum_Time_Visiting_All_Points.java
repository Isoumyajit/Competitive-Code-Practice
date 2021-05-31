import java.util.*;

public class Minimum_Time_Visiting_All_Points {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = s.nextInt();
            arr[i][1] = s.nextInt();
        }
        System.out.println(minTimeToVisitAllPoints(arr));
        s.close();
    }

    public static int minTimeToVisitAllPoints(int[][] points) {

        int minimumTime = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int x1 = points[i + 1][0];
            int y1 = points[i + 1][1];
            minimumTime += Math.max(Math.abs(x1 - x), Math.abs(y1 - y));
        }
        return minimumTime;
    }
}
