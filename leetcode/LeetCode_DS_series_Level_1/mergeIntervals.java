import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

        List<Integer> start = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        List<List<Integer>> helper = new LinkedList<>();
        int len = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if (o1[0] < o2[0]) {
                    return -1;
                } else
                    return 1;

            }

        });

        for (int i = 0; i < intervals.length; i++) {
            start.add(intervals[i][0]);
            ends.add(intervals[i][1]);
        }
        // System.out.println(start + " " + ends);
        int position = 0;
        int k = 0;
        while (position < len) {

            int j = position + 1;
            while (j < len && ends.get(k) >= start.get(j)) {
                j++;

            }
            k = j - 1;
            List<Integer> dummy = new ArrayList<Integer>();
            dummy.addAll(Arrays.asList(start.get(position), ends.get(k)));
            // System.out.println(dummy);
            helper.add(dummy);
            position = j;
            k = j;

        }
        int[][] answer = new int[helper.size()][2];
        for (int i = 0; i < helper.size(); i++) {
            answer[i][0] = helper.get(i).get(0);
            answer[i][1] = helper.get(i).get(1);
        }

        return answer;
    }
}
