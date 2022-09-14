package Hash_map;

import java.util.*;

public class longestPalindromeByConcatination {
    public int longestPalindrome(String[] words) {

        int maxPalindromeLen = 0;
        boolean flag = false;
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (String str : words) {
            if (!map.containsKey(str))
                continue;
            String dummyReverse = "";
            dummyReverse += str.charAt(1);
            dummyReverse += str.charAt(0);
            if (map.containsKey(dummyReverse)) {
                if (str.charAt(0) != str.charAt(1)) {
                    maxPalindromeLen += (Math.min(map.get(str), map.get(dummyReverse)) * 2) * 2;
                } else if (map.get(str) % 2 == 0) {
                    maxPalindromeLen += map.get(str) * 2;
                } else {
                    if (map.get(str) > 1) {
                        maxPalindromeLen += (map.get(str) - 1) * 2;
                        map.put(str, 1);
                    }
                    if (map.get(str) == 1 && flag) {
                        maxPalindromeLen += 2;
                        flag = true;
                    }
                }
            }
            map.remove(str);

        }
        return maxPalindromeLen;
    }
}
