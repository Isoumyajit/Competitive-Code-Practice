import java.util.*;

public class Contiguous_Array {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(findMaxLength(arr));
        s.close();
    }

    public static int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> helper = new HashMap<Integer, Integer>();
        int sum = 0, n = nums.length;
        int maxLength = 0, i = 0;

        for (i = 0; i < n; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        for (i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == 0) {
                maxLength = Math.max(i + 1, maxLength);
            } else if (!helper.containsKey(sum)) {
                helper.put(sum, i);
            } else {
                maxLength = Math.max((i - helper.get(sum)), maxLength);
            }
        }
        return maxLength;
    }
}
