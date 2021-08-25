import java.util.Scanner;

public class Min_Cost_Climbing_Stairs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(new Min_Cost_Climbing_Stairs().minCostClimbingStairs(arr));
        s.close();
    }

    public int minCostClimbingStairs(int[] cost) {

        int len = cost.length;
        for (int i = 2; i < len; i++) {
            cost[i] += Math.min(cost[i - 2], cost[i - 1]);
        }
        return Math.min(cost[len - 1], cost[len - 2]);
    }
}
