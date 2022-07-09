import java.util.ArrayList;
import java.util.HashMap;

public class longestFibonacciSeq {
    public int lenLongestFibSubseq(int[] arr) {

        int len = arr.length;
        HashMap<Integer, Integer> database = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        for (int index = 0; index < len; index++)
            database.put(arr[index], 1);
        for (int index = 0; index < len - 1; index++) {
            int a = arr[index];
            int count = 1;
            // ArrayList<Integer> lst = new ArrayList<>();
            for (int j = index + 1; j < len; j++) {
                if (database.containsKey(a + arr[j])) {
                    a = a + arr[j];
                    count += 2;
                    maxLen = Math.max(maxLen, count);
                }
            }
        }

        return maxLen;
    }
}