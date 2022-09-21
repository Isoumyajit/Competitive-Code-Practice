package Hash_map;

import java.util.*;

public class palidromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        Map<StringBuilder, Integer> map = new HashMap<>();
        List<List<Integer>> answerlst = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder str = new StringBuilder(words[i]);
            map.put(str.reverse(), i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                StringBuilder prefix = new StringBuilder(words[i].substring(0, j));
                StringBuilder suffix = new StringBuilder(words[i].substring(j));
                if (isPalindrome(prefix) && map.containsKey(suffix) && map.get(suffix) != i) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i, map.get(suffix));
                    answerlst.add(temp);
                } else if (isPalindrome(suffix) && map.containsKey(prefix) && map.get(prefix) != i) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i, map.get(suffix));
                    answerlst.add(temp);
                }
            }
        }

        return answerlst;
    }

    private static boolean isPalindrome(StringBuilder str) {
        StringBuilder str1 = new StringBuilder(str);
        return str1.equals(str.reverse());
    }
}
