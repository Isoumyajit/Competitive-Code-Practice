package StringProblems;

import java.util.ArrayList;
import java.util.List;

public class wordSubsets {
    public List<String> wordSubsets_(String[] words1, String[] words2) {
        List<String> answer = new ArrayList<>();

        int[] maxPresence = new int[26];
        for (String s : words1) {
            int[] hash = calculateFreq(s);
            for (int index = 0; index < 26; index++) {
                maxPresence[index] = Math.max(maxPresence[index], hash[index]);
            }
        }

        for (String s : words2) {
            int[] hash = calculateFreq(s);
            boolean flag = true;
            for (int index = 0; index < 26; index++) {
                if (!(hash[index] >= maxPresence[index])) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                answer.add(s);
        }
        return answer;
    }

    private static int[] calculateFreq(String s) {
        int[] hash = new int[26];
        for (char a : s.toCharArray())
            hash[a - 'a']++;
        return hash;
    }
}
