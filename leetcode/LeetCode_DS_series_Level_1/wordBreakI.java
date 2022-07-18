import java.util.List;

public class wordBreakI {
    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();
        int[] trackNum = new int[len];
        for (int index = 0; index < len; index++) {
            for (int word_cnt = 0; word_cnt <= index; word_cnt++) {
                String word = s.substring(word_cnt, index + 1);
                if (wordDict.contains(word)) {
                    if (word_cnt > 0)
                        trackNum[index] += trackNum[word_cnt - 1];
                    else
                        trackNum[index] += 1;
                }
            }
            if (trackNum[len - 1] > 0)
                return true;
        }
        return trackNum[len - 1] > 0;
    }
}