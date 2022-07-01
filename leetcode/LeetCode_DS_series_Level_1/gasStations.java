public class gasStations {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int len = gas.length;

        int start = 0;
        int tank = 0;
        int sh = 0;

        for (int index = 0; index < len; index++) {
            tank += gas[index] - cost[index];
            if (tank < 0) {
                sh += tank;
                tank = 0;
                start = index + 1;
            }
        }
        return (sh + tank >= 0) ? start : -1;
    }
}