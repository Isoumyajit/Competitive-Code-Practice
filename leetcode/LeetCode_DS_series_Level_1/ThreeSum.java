// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Example 2:

// Input: nums = []
// Output: []
// Example 3:

// Input: nums = [0]
// Output: []

// Constraints:

// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105

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

        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        int len = nums.length;
        int sum = 0;
        if (len < 3)
            return answer;
        if (len == 3) {
            for (int i = 0; i < len; i++) {
                sum += nums[i];
            }
            if (sum == 0) {
                List<Integer> dummy_ = new ArrayList<Integer>();
                for (int i : nums) {
                    dummy_.add(i);
                }

                answer.add(dummy_);
                return answer;
            }
        }
        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = len - 1;
                sum = -1 * nums[i];

                // Two pointer Algorithm starts from here

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        answer.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum)
                        high--;
                    else
                        low++;

                }
            }
        }

        return answer;
    }
}