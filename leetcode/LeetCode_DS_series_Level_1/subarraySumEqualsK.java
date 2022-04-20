import java.util.HashMap;
import java.util.Scanner;

public class subarraySumEqualsK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] usergiven = new int[n];
        for (int i = 0; i < n; i++) {
            usergiven[i] = sc.nextInt();
        }
        sc.close();
    }
}

class SolutionSubArraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        int count = 0;
        int len = nums.length;
        HashMap<Integer, Integer> helper = new HashMap<>();
        int prefixSum = 0;

        helper.put(prefixSum, 1);
        for (int i = 0; i < len; i++) {
            prefixSum += nums[i];
            if (helper.containsKey(prefixSum - k))
                count += helper.get(prefixSum - k);
            helper.put(prefixSum, helper.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
