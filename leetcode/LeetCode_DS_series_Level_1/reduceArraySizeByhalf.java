import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class reduceArraySizeByhalf {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> helper = new HashMap<>();
        for (int a : arr) {
            helper.put(a, helper.getOrDefault(a, 0) + 1);
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int a : arr) {
            if (helper.get(a) != 0)
                temp.add(helper.get(a));
            helper.put(a, 0);
        }
        Collections.sort(temp);
        int count = 0;
        int i = 0;
        int j = temp.size() - 1;
        int sum = arr.length / 2;
        // System.out.println(helper+" "+temp+" "+sum);
        while (i <= j) {

            if (temp.get(j) <= sum) {
                count++;
                sum -= temp.get(j);
                j--;
            } else if (temp.get(i) >= sum) {
                i++;
                count++;
                break;
            } else
                i++;
            if (sum <= 0)
                break;
        }

        if (count == 0)
            return 1;
        return count;
    }
}
