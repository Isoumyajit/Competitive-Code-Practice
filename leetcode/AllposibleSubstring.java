import java.util.*;

public class AllposibleSubstring {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        int target[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            target[i] = s.nextInt();
        }
        s.close();

        // ......
        List<Integer> helper = new ArrayList<Integer>();
        List<Integer> targetarray = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            helper.add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            targetarray.add(target[i]);
        }
        System.out.println(generateAllsubstring(targetarray, helper, 0, arr.length - 1));
    }

    public static boolean generateAllsubstring(List<Integer> target, List<Integer> helper, int i, int len) {
        if (i == len) {
            if (helper.equals(target))
                return true;
        }
        for (int j = i; j <= len; j++) {
            Collections.swap(helper, i, j);
            boolean flag = generateAllsubstring(target, helper, i + 1, len);
            if (flag)
                return true;
            Collections.swap(helper, i, j);
        }
        return false;
    }

}
