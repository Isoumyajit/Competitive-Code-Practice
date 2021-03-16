import java.util.*;

public class MinimumOperationsReducetoZero {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int target = s.nextInt();

        s.close();
        // ....
        int index = Integer.MAX_VALUE;
        ArrayList<Integer> helper = new ArrayList<Integer>();
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < arr.length; i++) {
            rightSum += arr[i];
            helper.add(rightSum);
            if (rightSum == target) {
                index = Math.min(index, i - 0 + 1);
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            leftSum += arr[i];
            if (helper.contains((target - leftSum))) {
                index = Math.min(index, helper.indexOf((target - leftSum)) - 0 + 1 + arr.length - i);
                break;
            } else if (leftSum == target) {
                index = Math.min(index, arr.length - i);
                break;
            }
        }
        if (index == Integer.MAX_VALUE)
            System.out.println(-1);
        System.out.println(index);
    }
}
