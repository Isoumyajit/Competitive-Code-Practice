import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Leetcode4Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(SolutionfourSum.fourSum(arr, target));
        sc.close();
    }
}

class SolutionfourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> answer = new LinkedList<>();
        Set<List<Integer>> helper = new HashSet<>();

        int len = nums.length;

        Arrays.sort(nums);
        if (len == 0)
            return answer;
        if (len == 4 && nums[0] + nums[1] + nums[2] + nums[3] == target) {
            answer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return answer;
        }
        for (int index = 0; index < len - 3; index++) {

            if (index == 0 || nums[index] != nums[index - 1]) {
                int b = index + 1;
                while (b < len - 2) {
                    int c = b + 1;
                    int d = len - 1;
                    while (c < d) {
                        if (nums[index] + nums[b] + nums[c] + nums[d] == target) {
                            helper.add(Arrays.asList(nums[index], nums[b], nums[c], nums[d]));

                            while (c < d && nums[c] == nums[c + 1])
                                c++;
                            while (d > c && nums[d] == nums[d - 1])
                                d--;
                            c++;
                            d--;
                        } else if (nums[index] + nums[b] + nums[c] + nums[d] > target)
                            d--;
                        else
                            c++;
                    }
                    while (b < len - 2 && nums[b] == nums[b + 1])
                        b++;
                    b++;
                }
            }
        }
        System.out.println(helper);
        for (List<Integer> x : helper) {
            answer.add(x);
        }
        return answer;

    }
}
