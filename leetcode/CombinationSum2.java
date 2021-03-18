import java.util.*;

public class CombinationSum2 {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int target = s.nextInt();
        s.close();

        // .....
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> helper = new ArrayList<Integer>();
        generateList(arr, result, helper, 0, target);
        System.out.println(result);
    }

    public static void generateList(int arr[], List<List<Integer>> result, List<Integer> helper, int i, int target) {

        if (target == 0) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(helper);
            Collections.sort(temp);
            if (!result.contains(temp))
                result.add(temp);
        } else {
            for (int id = i; id < arr.length; id++) {
                if (target < arr[id]) {
                    return;
                }
                helper.add(arr[id]);
                generateList(arr, result, helper, id + 1, target - arr[id]);
                helper.remove(helper.size() - 1);
            }
        }

    }
}
