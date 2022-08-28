package Prefix_Sum;

public class minimumAmountOftimeToCollectGarbage {
    public int garbageCollection(String[] garbage, int[] travel) {
        int totalTime = 0;
        int[][] hash = { { 0, 0 }, { 0, 0 }, { 0, 0 } };
        getPrefix(travel);
        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];
            for (char a : s.toCharArray()) {
                if (a == 'G') {
                    hash[0][0]++;
                    hash[0][1] = i;
                } else if (a == 'P') {
                    hash[1][0]++;
                    hash[1][1] = i;
                } else if (a == 'M') {
                    hash[2][0]++;
                    hash[2][1] = i;
                }
            }
        }

        totalTime = hash[0][0] + hash[1][0] + hash[2][0];
        for (int i = 0; i < 3; i++) {
            int destination = hash[i][1];
            if (destination > 0)
                totalTime += travel[destination - 1];
        }

        return totalTime;
    }

    private static void getPrefix(int[] a) {

        for (int i = 1; i < a.length; i++) {
            a[i] += a[i - 1];
        }
    }
}
