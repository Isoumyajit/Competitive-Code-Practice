package Hash_map;

import java.util.HashMap;
import java.util.Map;

public class splitArrayintoConsecutiveSequence {
    public boolean isPossible(int[] nums) {

        if (nums.length < 3)
            return false;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> asm = new HashMap<>();
        for (int val : nums)
            freq.put(val, freq.getOrDefault(val, 0) + 1);

        for (int val : nums) {
            if (freq.get(val) == 0)
                continue;
            else if (asm.get(val) != null && asm.get(val) > 0) {
                asm.put(val, asm.get(val) - 1);
                freq.put(val, freq.get(val) - 1);
                asm.put(val + 1, asm.getOrDefault(val + 1, 0) + 1);
            } else if (freq.containsKey(val + 1) && freq.containsKey(val + 2) && freq.get(val + 1) > 0
                    && freq.get(val + 2) > 0) {
                freq.put(val + 1, freq.get(val + 1) - 1);
                freq.put(val + 2, freq.get(val + 2) - 1);
                if (freq.containsKey(val - 1) && freq.get(val - 1) > 0)
                    freq.put(val - 1, freq.get(val - 1) - 1);
                freq.put(val, freq.get(val) - 1);
                asm.put(val + 3, asm.getOrDefault(val + 3, 0) + 1);
            } else
                return false;
        }

        return true;
    }
}
