import java.util.*;

public class Min_ClimbStairs {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        StringTokenizer st = new StringTokenizer(str, ",");
        ArrayList<Integer> helper = new ArrayList<Integer>();

        while (st.hasMoreTokens()) {
            helper.add(Integer.valueOf(st.nextToken()));
        }

        int arr[] = new int[helper.size()];
        for (int i = 0; i < helper.size(); i++) {
            arr[i] = helper.get(i);
        }

        int cost = arr[0];
        int cost1 = arr[1];
        for (int i = 0; i < arr.length - 2;) {
            int minInd = getMin(arr, i + 1, i + 2);
            i = minInd;
            cost += arr[minInd];
        }
        for (int i = 1; i < arr.length - 2;) {
            int minInd = getMin(arr, i + 1, i + 2);
            i = minInd;
            cost1 += arr[minInd];
        }
        System.out.println(Math.min(cost, cost1));
    }

    public static int getMin(int arr[], int i, int j) {

        if (arr[i] > arr[j])
            return j;
        return i;
    }
}
