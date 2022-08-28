package StringProblems;

import java.util.HashMap;
import java.util.Map;

public class strigCompression {
    public int compress(char[] chars) {

        Map<Character, Integer> map = new HashMap<>();
        char[] answer = new char[chars.length];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 || map.containsKey(chars[i]))
                map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            else {
                index = getFilled(answer, map.get(chars[i - 1]), chars[i - 1], index);
                map.remove(chars[i - 1]);
                map.put(chars[i], 1);
            }
            if (i + 1 == chars.length)
                index = getFilled(answer, map.get(chars[i]), chars[i], index);
        }
        for (int i = 0; i < index; i++) {
            chars[i] = answer[i];
        }
        return index;
    }

    private static int getFilled(char[] ans, int num, char x, int ind) {

        int index = ind;
        String number = String.valueOf(num);
        ans[index++] = x;
        if (num > 1)
            for (char digits : number.toCharArray()) {
                ans[index] = digits;
                index++;
            }
        return index;
    }
}
