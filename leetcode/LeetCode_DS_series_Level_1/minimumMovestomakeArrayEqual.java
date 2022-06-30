import java.util.Arrays;

public class minimumMovestomakeArrayEqual {
    public int minMoves2(int[] nums) {

        int len = nums.length;
        int count = 0;
        if (len == 0)
            return 0;
        if (len == 1)
            return 0;
        if (len == 2) {
            if (nums[0] == nums[1])
                return 0;
            else
                return Math.abs(nums[1] - nums[0]);
        }
        Arrays.sort(nums);
        int mid = len % 2 == 0 ? (len / 2 - 1) : (len / 2);
        for (int index = 0; index < len; index++) {
            count += Math.abs(nums[index] - nums[mid]);
        }
        return count;
    }
}
