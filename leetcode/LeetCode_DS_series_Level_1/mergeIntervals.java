import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class mergeIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] usergiven = new int[n][2];
        for (int i = 0; i < n; i++) {
            usergiven[i][0] = sc.nextInt();
            usergiven[i][1] = sc.nextInt();
        }

        int[][] res = SolutionmergeIntervals.merge(usergiven);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
        sc.close();
    }
}

class SolutionmergeIntervals {
    public static int[][] merge(int[][] intervals) {

        int len = intervals.length;
        List<List<Integer>> helper = new LinkedList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else if (end < intervals[i][0]) {
                List<Integer> lst = new ArrayList<Integer>();
                lst.addAll(Arrays.asList(start, end));
                start = intervals[i][0];
                end = intervals[i][1];
                helper.add(lst);
            }
        }
        helper.add(Arrays.asList(start, end));
        int[][] answer = new int[helper.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i][0] = helper.get(i).get(0);
            answer[i][1] = helper.get(i).get(1);
        }
        return answer;
    }
}

// Solution 2
class SolutionmergeIntervals1 {
    public static int[][] merge(int[][] intervals) {

        // if(intervals.length == 1)return new int[0][];
        int len = intervals.length;
        List<int[]> answer = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else if (end < intervals[i][0]) {
                answer.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];

            }
        }
        answer.add(new int[] { start, end });

        return answer.toArray(new int[0][]);
    }
}