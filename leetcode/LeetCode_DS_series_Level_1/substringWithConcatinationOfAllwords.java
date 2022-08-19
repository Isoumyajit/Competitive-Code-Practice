import java.util.*;

public class substringWithConcatinationOfAllwords {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> answer = new ArrayList<>();
        slidingWindow(s, words, answer);
        return answer;

    }

    private static void slidingWindow(String s, String[] words, List<Integer> answer) {
        Map<String, Integer> dic = new HashMap<>();
        Map<String, Integer> wordSeen = new HashMap<>();
        int len = s.length();
        int wordLen = words[0].length();
        boolean isExcess = false;
        int left = 0;
        int wordused = 0;
        int substringLen = wordLen * words.length;

        for (String st : words) {
            dic.put(st, dic.getOrDefault(st, 0) + 1);
        }

        for (int i = left; i < len; i++) {
            String sub = s.substring(i, i + wordLen);
            if (!dic.containsKey(sub)) {
                wordSeen.clear();
                isExcess = false;
                left = i + wordLen;
                wordused = 0;
            } else {

                while (left - i == substringLen || isExcess) {
                    String substr = s.substring(left, left + wordLen);
                    left += wordLen;
                    wordSeen.put(substr, wordSeen.getOrDefault(substr, 0) - 1);
                    if (wordSeen.get(substr) >= dic.get(substr)) {
                        isExcess = false;
                    } else {
                        wordused--;
                    }
                }

                wordSeen.put(sub, wordSeen.getOrDefault(sub, 0) + 1);
                if (wordSeen.get(sub) <= dic.get(sub)) {
                    wordused++;
                } else {
                    isExcess = true;
                }
                if (wordused == words.length && !isExcess) {
                    answer.add(left);
                }
            }
        }
    }
}
