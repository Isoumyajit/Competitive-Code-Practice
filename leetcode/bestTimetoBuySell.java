import java.util.*;

public class bestTimetoBuySell {
    public static void main(String[] args) {
        int maxProfit = Integer.MIN_VALUE;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        PriorityQueue<Integer> helper = new PriorityQueue<Integer>();
        if (n > 0)
            helper.add(arr[0]);
        else
            System.exit(0);

        for (int i = 1; i < n; i++) {
            if (arr[i] - helper.peek() > 0) {
                maxProfit = Math.max(maxProfit, arr[i] - helper.peek());
            }
            helper.add(arr[i]);
        }
        System.out.print(maxProfit);
        s.close();
    }
}
