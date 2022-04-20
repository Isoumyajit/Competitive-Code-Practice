import java.util.Scanner;

public class increasingTripletSubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] usergiven = new int[n];
        for (int i = 0; i < n; i++) {
            usergiven[i] = sc.nextInt();
        }

        System.out.println(SolutionincreasingTripletSubsequence.increasingTriplet(usergiven));
        sc.close();
    }
}

class SolutionincreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int len = nums.length;
        boolean res = false;
        if (len < 3)
            return res;

        for (int i = 0; i < len; i++) {

            if (nums[i] <= first)
                first = nums[i];
            else if (nums[i] <= second)
                second = nums[i];
            else
                return !res;
        }

        return res;

    }
}
