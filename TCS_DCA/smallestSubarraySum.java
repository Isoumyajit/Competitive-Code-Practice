import java.util.*;

public class smallestSubarraySum {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int target = s.nextInt();
        s.close();
        // .....
        int cur_sum = 0, width = Integer.MAX_VALUE;
        Deque<Integer> helper = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            cur_sum += arr[i];
            helper.addLast(i);

            while (cur_sum >= target && helper.size() > 0) {
                width = Math.min(width, i - helper.peekFirst() + 1);
                int element = helper.pollFirst();
                cur_sum -= arr[element];
            }

        }
        if (width == Integer.MAX_VALUE)
            return;
        System.out.println(width);
    }
}
