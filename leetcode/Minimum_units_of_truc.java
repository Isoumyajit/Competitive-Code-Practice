import java.util.*;

public class Minimum_units_of_truc {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int boxes[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                boxes[i][j] = s.nextInt();
            }
        }
        int truckS = s.nextInt();

        Solution_Units_in_truck obj = new Solution_Units_in_truck();
        System.out.println(obj.maximumUnits(boxes, truckS));
        s.close();
    }
}

class Solution_Units_in_truck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        int i, j;
        List<Pair<Integer, Integer>> ls = new ArrayList<Pair<Integer, Integer>>();

        for (i = 0; i < boxTypes.length; i++) {

            for (j = 0; j < 2; j++) {

                ls.add(new Pair(boxTypes[i][0], boxTypes[i][1]));
            }
        }

        Collections.sort(ls, new Comparator<Pair<Integer, Integer>>() {

            public int compare(final Pair<Integer, Integer> o1, final Pair<Integer, Integer> o2) {

                return o1.getValue().compareTo(o2.getValue());
            }
        });

        int sum = 0, total_box = 0, remains = truckSize;

        Iterator<Pair<Integer, Integer>> it = ls.iterator();

        while (it.hasNext()) {

            if (remains > it.next().getKey()) {

                sum += it.next().getKey() * ls.get(i).getValue();

            } else {

                sum += it.next().getValue() * remains;
                break;
            }
            total_box += it.next().getKey();
            remains = truckSize - total_box;
        }
        System.out.println(ls);

        return sum;
    }
}