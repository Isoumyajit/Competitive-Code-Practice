import java.util.*;

public class MaximumBeweenWidth {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(new SolutionWidth().maxWidthRamp(arr));
        s.close();
    }
}

class SolutionWidth {
    public int maxWidthRamp(int[] A) {

        int max_width = 0;
        Stack<Integer> temp = new Stack<Integer>();
        Stack<Integer> helper = new Stack<Integer>();
        for (int i = A.length - 1; i >= 0; i--) {

            if (temp.size() == 0) {
                temp.push(i);
            } else {
                while (!temp.isEmpty() && A[temp.peek()] >= A[i]) {
                    max_width = Math.max(max_width, temp.peek() - i);
                    helper.push(temp.peek());
                    temp.pop();
                }
                while (!helper.isEmpty()) {
                    temp.push(helper.peek());
                    helper.pop();
                }
                if (!temp.isEmpty() && A[temp.peek()] <= A[i]) {
                    temp.push(i);
                }
            }
        }
        return max_width;
    }
}