package Search_in_sorted_rotated_array;

import java.util.*;

class search_in_rotated_sortedArray {
     public static void main(String args[]) {
          Scanner s = new Scanner(System.in);
          int n = s.nextInt();

          int nums[] = new int[n];
          for (int i = 0; i < n; i++)
               nums[i] = s.nextInt();
          int target = s.nextInt();
          Solution obj = new Solution();
          System.out.print(obj.search(nums, target));
          s.close();
     }
}

class Solution {
     public int search(int[] nums, int target) {

          int i, j, mid, index;
          i = 0;
          j = nums.length - 1;

          for (i = j; i > 0;) {
               if (nums[i] > nums[i - 1])
                    i--;
               else {
                    index = i;
                    break;
               }
          }

          int a = Solution.binarySrch(nums, target, 0, i - 1);
          if (a != -1)
               return a;
          int b = Solution.binarySrch(nums, target, i, j);

          return Math.max(a, b);

     }

     public static int binarySrch(int nums[], int target, int start, int end) {
          int i = start, mid = 0;
          int j = end;
          while (i <= j) {
               mid = i + (j - i) / 2;
               if (nums[mid] == target)
                    return mid;
               else if (nums[mid] > target)
                    j = mid - 1;
               else
                    i = mid + 1;

          }
          return -1;
     }
}