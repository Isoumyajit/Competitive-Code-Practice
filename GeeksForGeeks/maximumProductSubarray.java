
/**Maximum Product Subarray 
Medium Accuracy: 29.84% Submissions: 53193 Points: 4
Given an array Arr that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.

Example 1:

Input:
N = 5
Arr[] = {6, -3, -10, 0, 2}
Output: 180
Explanation: Subarray with maximum product
is 6, -3, -10 which gives product as 180.
Example 2:

Input:
N = 6
Arr[] = {2, 3, 4, 5, -1, 0}
Output: 120
Explanation: Subarray with maximum product
is 2, 3, 4, 5 which gives product as 120.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxProduct() which takes the array of integers arr and n as parameters and returns an integer denoting the answer.
Note: Use 64-bit integer data type to avoid overflow.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 500
-102 ≤ Arri ≤ 102 */

import java.io.*;

public class maximumProductSubarray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution_maximumProducutSubarray().maxProduct(arr, n));
        }
    }
}

class Solution_maximumProducutSubarray {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long currentProd = 1;
        long highestProd = Integer.MIN_VALUE;
        long minimumProd = 1;
        long cornerCase = 1;

        for (int i = 0; i < n; i++) {
            cornerCase *= arr[i];
            if (arr[i] == 0) {
                minimumProd = 1;
                currentProd = 1;
                continue;
            }
            long temp = currentProd;
            currentProd = max(arr[i], arr[i] * currentProd, arr[i] * minimumProd);
            minimumProd = min(arr[i], arr[i] * minimumProd, arr[i] * temp);
            highestProd = Math.max(currentProd, highestProd);
        }

        return Math.max(cornerCase, highestProd);
    }

    public static long max(long a, long b, long c) {
        return (a > b && a > c) ? a : (b > c) ? b : c;
    }

    public static long min(long a, long b, long c) {
        return (a < b && a < c) ? a : (b < c) ? b : c;
    }
}