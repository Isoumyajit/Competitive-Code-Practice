package Hash_map;

import java.util.Arrays;
import java.util.Comparator;

public class taskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[][] hash = new int[26][2];
        int count = 0;
        int jobs = 0;
        for (char task : tasks) {
            hash[task - 'A'][1]++;
        }

        for (int val[] : hash)
            jobs += val[1];
        boolean flag = false;
        while (jobs > 0) {
            flag = false;
            Arrays.sort(hash, new sortcomparator());
            for (int i = 0; i < 26; i++) {

                if (hash[i][0] > 0) {
                    hash[i][0] -= 1;
                } else if (!flag && hash[i][1] > 0) {
                    hash[i][1] -= 1;
                    jobs--;
                    hash[i][0] = n;
                    flag = true;
                }
            }
            count++;
        }

        return count;
    }
}

class sortcomparator implements Comparator<int[]> {

    @Override
    public int compare(int[] a, int b[]) {
        if (a[0] != b[0])
            return Integer.compare(b[0], a[0]);
        else
            return Integer.compare(b[1], a[1]);
    }
}