import java.util.*;

public class insertionOfTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> temp1 = new ArrayList<Integer>();
        ArrayList<Integer> temp2 = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        // int[] arr = new int[n];
        // int x = Arrays.stream(arr).max().getAsInt();
        for (int i = 0; i < n; i++) {
            temp1.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            temp2.add(sc.nextInt());
        }
        sc.close();
        HashMap<Integer, Integer> helper = new HashMap<Integer, Integer>();
        for (int i = 0; i < temp1.size(); i++) {
            helper.put(temp1.get(i), helper.getOrDefault(temp1.get(i), 0) + 1);
        }
        for (int i = 0; i < temp2.size(); i++) {
            if (helper.get(temp2.get(i)) != 0 && helper.containsKey(temp2.get(i))) {
                result.add(temp2.get(i));
                helper.put(temp2.get(i), helper.get(temp2.get(i)) - 1);
            }
        }
        System.out.println(result);
    }
}
