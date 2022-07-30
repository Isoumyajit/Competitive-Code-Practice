package Backtracking_And_Memoraization;

import java.util.ArrayList;
import java.util.List;

public class combinationsSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> helper = new ArrayList<>();
        generateNum(1, n, k, answer, helper, 0);
        return answer;

    }

    private static void generateNum(int index, int target, int count, List<List<Integer>> answer,
            ArrayList<Integer> helper, int sum) {

        if (sum > target)
            return;
        if (index == 10) {
            if (count == 0) {
                if (sum == target) {
                    answer.add(new ArrayList<>(helper));
                }
            }
            return;
        }
        if (count == 0) {
            if (sum == target) {
                answer.add(new ArrayList<>(helper));
            }
            return;
        }

        for (int i = index; i <= 9; i++) {
            helper.add(i);
            generateNum(i + 1, target, count - 1, answer, helper, sum + i);
            helper.remove(helper.size() - 1);
        }

    }
}