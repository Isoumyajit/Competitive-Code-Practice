import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {

        int len = ratings.length;
        int answer = len;
        if (len == 1)
            return 1;

        int[] calculate_candies = new int[len];
        Arrays.fill(calculate_candies, 1);

        for (int index = 1; index < len; index++) {
            if (calculate_candies[index] <= calculate_candies[index - 1] && ratings[index] > ratings[index - 1]) {

                answer += (calculate_candies[index - 1] + 1 - calculate_candies[index]);
                calculate_candies[index] = calculate_candies[index - 1] + 1;

            }
        }
        for (int index = len - 2; index >= 0; index--) {
            if (calculate_candies[index] <= calculate_candies[index + 1] && ratings[index] > ratings[index + 1]) {
                answer += (calculate_candies[index + 1] + 1 - calculate_candies[index]);
                calculate_candies[index] = calculate_candies[index + 1] + 1;

            }
        }
        // for(int values : calculate_candies)answer += values;
        return answer;
    }
}