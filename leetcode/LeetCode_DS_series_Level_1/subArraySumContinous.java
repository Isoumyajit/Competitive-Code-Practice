import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        boolean answer = false;
        int len = nums.length;
        if (len == 1)
            return false;
        HashMap<Integer, Integer> modulo_hash = new HashMap<>();
        int sum = 0;
        modulo_hash.put(0, -1);
        for (int index = 0; index < len; index++) {

            sum += nums[index];
            int rem = sum % k;
            if (index - 0 > 1 && rem == 0)
                return !answer;
            else if (modulo_hash.containsKey(rem) && (index - modulo_hash.get(rem)) > 1)
                return !answer;
            else if (!modulo_hash.containsKey(rem))
                modulo_hash.put(rem, index);
        }
        return answer;
    }
}