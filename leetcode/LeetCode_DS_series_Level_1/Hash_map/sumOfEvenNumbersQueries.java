package Hash_map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class sumOfEvenNumbersQueries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

        int sum = 0;
        int indexQ = 0;
        Set<Integer> set = new HashSet<>();
        List<Integer> lst = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 0) {
                sum += nums[i];
                set.add(i);
            }
        }

        for (int[] q : queries) {
            int val = q[0];
            int index = q[1];
            int getVal = nums[index];
            int currentVal = getVal + val;
            if (set.contains(index)) {
                sum -= nums[index];
            }

            if (currentVal % 2 == 0) {
                sum += currentVal;

            } else {
                if (set.contains(index))
                    set.remove(index);
            }
            if (sum % 2 == 0) {
                lst.add(sum);
                if (currentVal % 2 == 0)
                    set.add(index);
            }
            nums[index] = currentVal;
        }
        int[] answer = new int[lst.size()];
        for (int val : lst)
            answer[indexQ++] = val;
        return answer;
    }
}
