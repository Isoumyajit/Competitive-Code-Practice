/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
Example 4:

Input: candidates = [1], target = 1
Output: [[1]]
Example 5:

Input: candidates = [1], target = 2
Output: [[1,1]]
 

Constraints:

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500
*/

import java.util.*;

public class CombiationSum {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int target = s.nextInt();
        s.close();
        // .....
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> helper = new ArrayList<Integer>();
        generateList(arr, result, helper, target, 0);
        System.out.println(result);
    }

    // static int sum = 0;

    public static void generateList(int arr[], List<List<Integer>> result, List<Integer> helper, int target, int id) {
        if (target < 0) {
            helper.remove(helper.size() - 1);
            return;
        }
        if (target == 0) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(helper);
            // helper.remove(helper.size() - 1);
            Collections.sort(temp);
            if (!result.contains(temp))
                result.add(temp);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (target < arr[i]) {
                    return;
                }
                helper.add(arr[i]);
                generateList(arr, result, helper, target - arr[i], id);
                helper.remove(helper.size() - 1);
            }
        }
    }
}
