
/*

Reference -- https://leetcode.com/problems/container-with-most-water/


Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
Example 3:

Input: height = [4,3,2,1,4]
Output: 16
Example 4:

Input: height = [1,2,1]
Output: 2
 

Constraints:

n = height.length
2 <= n <= 3 * 104
0 <= height[i] <= 3 * 104
*/

import java.util.*;

public class Contained_With_Most_Water {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), maxsum = 0;
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();

        for (int i = 0, j = arr.length - 1; i < j;) {
            int minimum = Math.min(arr[i], arr[j]);
            maxsum = Math.max(maxsum, (j - i) * minimum);
            if (arr[i] < arr[j])
                i++;
            else
                j--;
        }
        System.out.println("The total Water is " + maxsum);
    }
}
