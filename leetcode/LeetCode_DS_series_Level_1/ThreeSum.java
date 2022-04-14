import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] usergiven = new int[n];
        for (int i = 0; i < n; i++) {
            usergiven[i] = sc.nextInt();
        }

        System.out.println(SolutionThreeSum.threeSum(usergiven));
        sc.close();
    }
}

class SolutionThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        ArrayList<Integer> counter = new ArrayList<Integer>();
        for (int val : nums) {
            counter.add(val);
        }
        for (int i = 0, j = len - 1; i + 2 <= j;) {
            int sum = nums[i] + nums[j];
            if (counter.contains(sum * -1)) {
                if (counter.indexOf(sum * -1) != j) {
                    List<Integer> dummy = new ArrayList<Integer>();
                    dummy.add(nums[i]);
                    dummy.add(sum * -1);
                    dummy.add(nums[j]);
                    j--;
                    answer.add(dummy);
                    // dummy.clear();
                }
            } else {
                i++;
            }
        }
        return answer;
    }
}