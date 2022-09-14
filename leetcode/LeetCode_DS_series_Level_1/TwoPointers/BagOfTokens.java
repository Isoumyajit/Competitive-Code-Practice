package TwoPointers;

import java.util.Arrays;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int start = 0;
        int end = tokens.length - 1;
        int score = 0;
        int maxScore = 0;

        while (start <= end) {

            if (power >= tokens[start]) {
                power -= tokens[start];
                score++;
                start++;
                maxScore = Math.max(maxScore, score);
            } else {
                if (score > 0) {
                    power += tokens[end];
                    score -= 1;
                    end--;
                } else
                    return maxScore;
            }
        }
        return maxScore;
    }
}
