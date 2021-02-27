import java.util.*;

public class Nth_smallestNumber {

    public static void main(String args[]) {
        int n;
        Scanner s = new Scanner(System.in);
        int arr[] = new int[n = s.nextInt()];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int nth_term = s.nextInt();
        PriorityQueue<Integer> temp = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            temp.add(arr[i]);
            if (temp.size() > nth_term) {
                temp.poll();
            }
        }
        if (temp.size() >= 1) {
            System.out.println(temp.peek());
        }
        s.close();
    }
}
