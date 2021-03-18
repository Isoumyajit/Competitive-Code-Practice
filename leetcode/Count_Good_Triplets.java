/*

reference of the problem ---- > https://leetcode.com/problems/count-good-triplets/
Count Good Triplets
Add to List

Share
Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.

A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:

0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
Where |x| denotes the absolute value of x.

Return the number of good triplets.

 

Example 1:

Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
Output: 4
Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].
Example 2:

Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
Output: 0
Explanation: No triplet satisfies all conditions.
 

Constraints:

3 <= arr.length <= 100
0 <= arr[i] <= 1000
0 <= a, b, c <= 1000
*/

import java.util.*;

public class Count_Good_Triplets {
   public static void main(String args[]) {
      Scanner s = new Scanner(System.in);
      int i, j, k, cnt = 0;
      int a, b, c;
      int n = s.nextInt();
      a = s.nextInt();
      b = s.nextInt();
      c = s.nextInt();
      int arr[] = new int[n];
      int len = arr.length;
      for (i = 0; i < len; i++)
         arr[i] = s.nextInt();

      s.close();
      // ....
      for (i = 0; i < len; i++) {
         for (j = i + 1; j < len; j++) {
            if (Math.abs(arr[i] - arr[j]) > a)
               continue;
            for (k = j + 1; k < len; k++) {
               if (Math.abs(arr[k] - arr[j]) <= b && Math.abs(arr[i] - arr[k]) <= c)
                  cnt++;
            }
         }
      }
      System.out.println(cnt);
   }
}
