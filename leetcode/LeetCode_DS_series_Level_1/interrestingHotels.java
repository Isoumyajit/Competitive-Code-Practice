import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class interrestingHotels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int index = 0; index < n; index++)
            arr.add(sc.nextInt());
        System.out.println(hotels(n, k, arr));
    }

    public static ArrayList<Integer> hotels(int n, int k, ArrayList<Integer> a) {
        // Write your code here
        Deque<Integer> helper = new ArrayDeque<Integer>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int index = n - 1; index >= 0; index--) {
            int kCopy = 0;
            if (index == n - 1) {
                helper.add(index);
                answer.add(index);
            } else {
                while (!helper.isEmpty() && a.get(helper.getLast()) < a.get(index)) {
                    helper.pollLast();
                    kCopy++;
                }
                if (kCopy >= k || helper.isEmpty()) {
                    answer.add(index);
                }
                while (!helper.isEmpty() && helper.getFirst() - index + 1 > k)
                    helper.pollFirst();
            }
            helper.addLast(index);
        }
        Collections.reverse(answer);
        return answer;
    }
}