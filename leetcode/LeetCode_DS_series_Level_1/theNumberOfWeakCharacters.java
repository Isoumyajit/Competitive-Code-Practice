import java.util.*;

public class theNumberOfWeakCharacters {
    public int numberOfWeakCharacters(int[][] properties) {

        int count = 0;
        int n = properties.length;
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if (o1[0] == o2[0])
                    return Integer.compare(o2[1], o1[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int maxDef = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {

            if (properties[i][1] < maxDef) {
                count++;
            }
            if (maxDef < properties[i][1])
                maxDef = properties[i][1];
        }
        return count;
    }

}
