package Hash_map;

import java.util.Collections;
import java.util.PriorityQueue;

public class minimumNumberofRefuelingstp {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations.length == 0) {
            if (startFuel >= target)
                return 0;
            else
                return -1;
        }
        if (target <= startFuel)
            return 0;
        if (stations[0][0] > startFuel)
            return -1;
        PriorityQueue<Integer> helper = new PriorityQueue<>(Collections.reverseOrder());

        int count = 0;
        int index = 0;

        while (startFuel < target) {
            while (index < stations.length && startFuel >= stations[index][0]) {
                helper.offer(stations[index][1]);
                index++;
            }
            if (!helper.isEmpty()) {
                startFuel += helper.poll();
                count++;
            } else
                return -1;
        }
        return count;
    }
}