package SlidingWindow;

public class numberOfSubarraysOfsizeK {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int start = 0;
        int end = 0;
        int len = arr.length;
        int count = 0;
        int sum = 0;
        while (end < len) {
            sum += arr[end];
            if (end - start + 1 == k) {
                int avg = sum / k;
                if (avg >= threshold) {
                    count++;
                }
                sum -= arr[start++];
            }
            end++;
        }

        return count;
    }
}
