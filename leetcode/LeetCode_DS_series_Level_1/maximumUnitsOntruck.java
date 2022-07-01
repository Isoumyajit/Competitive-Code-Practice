import java.util.Arrays;

public class maximumUnitsOntruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        int len = boxTypes.length;
        if (len == 0)
            return 0;
        if (truckSize == 0)
            return 0;
        if (len == 1) {
            if (truckSize >= boxTypes[0][0])
                return boxTypes[0][0] * boxTypes[0][1];
            else
                return truckSize % boxTypes[0][0] * boxTypes[0][1];
        }

        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int maxUnits = 0;
        for (int index = 0; index < len; index++) {
            if (truckSize >= boxTypes[index][0]) {
                maxUnits += boxTypes[index][1] * boxTypes[index][0];
                truckSize -= boxTypes[index][0];
            } else {
                maxUnits += (truckSize % boxTypes[index][0]) * (boxTypes[index][1]);
                truckSize -= truckSize % boxTypes[index][0];
            }
            if (truckSize <= 0)
                break;
        }
        return maxUnits;
    }
}