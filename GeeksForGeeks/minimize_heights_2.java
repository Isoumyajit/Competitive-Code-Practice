
import java.io.*;
import java.util.*;

class minimize_heights_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution_minimize().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends

class Solution_minimize {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int minimum = arr[n - 1] - arr[0];
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
        for (int i = 0; i < n - 1; i++) {
            int prev = Math.min(smallest, arr[i + 1] - k);
            int next = Math.max(largest, arr[i] + k);
            if (prev < 0)
                continue;
            minimum = Math.min(minimum, (next - prev));
        }

        /*
         * for(int i = 0 ; i < helper.size() ; i++) System.out.print(helper.get(i)
         * +" ");
         */

        return minimum;
    }
}
