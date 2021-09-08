
// { Driver Code Starts
import java.io.*;
import java.util.*;

class longestIncreasingSubsequence {
    public static void main(String args[]) throws IOException {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();
        while (t > 0) {

            // taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];

            // inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }
            sc.close();
            // creating an object of class Solution

            // calling longestSubsequence() method of class
            // Solution
            System.out.println(Solution_longestSubsequence.longestSubsequence(n, array));
            t--;
        }
    }
} // } Driver Code Ends

class Solution_longestSubsequence {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int arr[]) {
        // code here
        int[] helper = new int[size];
        int maxLength = 0;
        Arrays.fill(helper, 1);
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[i] > arr[j]) {
                    if (helper[j] >= helper[i]) {
                        helper[i] = 1 + helper[j];
                        maxLength = Math.max(helper[i], maxLength);
                    }
                }
            }

        }
        return maxLength;
    }
}