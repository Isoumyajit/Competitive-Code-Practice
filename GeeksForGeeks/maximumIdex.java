package GeeksForGeeks;

import java.io.*;

public class maximumIdex {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim()); // size of array
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
            }

            System.out.println(Solution_maximum_index.maxIndexDiff(arr, n)); // print the result
        }
    }
}

class Solution_maximum_index {

    // arr[]: input array
    // n: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int arr[], int n) {

        // Your code here
        int[] left = new int[n];
        int[] right = new int[n];
        int smallest = arr[0];
        int largest = arr[n - 1];
        left[0] = arr[0];
        right[n - 1] = arr[n - 1];
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (smallest > arr[i]) {
                smallest = arr[i];
                left[i] = smallest;
            } else {
                left[i] = smallest;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (largest < arr[i]) {
                largest = arr[i];
                right[i] = largest;
            } else {
                right[i] = largest;
            }
        }

        for (int i = 0, j = 0; i < n && j < n;) {
            if (left[i] <= right[j]) {
                result = Math.max(result, j - i);
                j++;
            } else {
                i++;
            }
        }
        return result;
    }

}
