import java.util.HashMap;
import java.util.Scanner;

public class majorityElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] usergiven = new int[n];
        for (int i = 0; i < n; i++) {
            usergiven[i] = sc.nextInt();
        }

        System.out.println(SolutionMajorityElement.majorityElement(usergiven));
        sc.close();
    }
}

class SolutionMajorityElement {
    public static int majorityElement(int[] nums) {

        int len = nums.length;
        int element = nums[0];
        HashMap<Integer, Integer> helper = new HashMap<Integer, Integer>();
        for (int keys : nums) {
            helper.put(keys, helper.getOrDefault(keys, 0) + 1);
            if (helper.get(keys) > len / 2)
                element = keys;
        }
        return element;

    }
}