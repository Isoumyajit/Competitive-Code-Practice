import java.util.*;

public class Nth_Largest {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int k = s.nextInt();
        s.close();
        // .....
        PriorityQueue<Integer> helper = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            if (helper.size() == 0) {
                helper.add(arr[i]);
            }
            helper.add(arr[i]);
            if (k < helper.size()) {
                helper.poll();
            }
        }
        System.out.println(helper.peek());
    }
}
