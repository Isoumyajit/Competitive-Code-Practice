import java.util.*;

public class two_sum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int target = s.nextInt();
        int res[] = new two_sum().twoSum(arr, target);

        for (int i = 0; i < 2; i++) {
            System.out.println(res[i]);
        }
        s.close();
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        // System.out.println(map);
        for (int i = 0; i < len; i++) {

            if (map.containsKey(target - nums[i])) {

                int index = map.get(target - nums[i]);
                if (index != i) {
                    result[1] = map.get(target - nums[i]);
                    break;
                }
            }

        }
        return result;
    }
}
