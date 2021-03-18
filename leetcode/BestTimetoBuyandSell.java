import java.util.*;

public class BestTimetoBuyandSell {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int prices[] = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = s.nextInt();
        }

        s.close();
        // .....
        int maxProfit = 0;
        Stack<Integer> helper = new Stack<Integer>();
        int difference = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (helper.size() == 0) {
                helper.push(prices[i]);
            } else {
                if (!helper.isEmpty() && helper.peek() < prices[i]) {
                    difference = Math.max(difference, prices[i] - helper.peek());
                    // helper.push(prices[i]);
                    if (difference > prices[i] - helper.peek()) {
                        maxProfit += difference;
                        difference = Integer.MIN_VALUE;
                        while (!helper.isEmpty()) {
                            helper.pop();
                        }
                        helper.push(prices[i]);
                    }
                } else {
                    while (!helper.isEmpty() && helper.peek() >= prices[i]) {
                        helper.pop();
                    }
                    helper.push(prices[i]);
                }
            }
        }
        maxProfit += Math.max(difference, maxProfit);
        System.out.println(maxProfit);
    }
}
