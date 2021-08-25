import java.util.*;

public class Contains_Duplicate {
    public static void main(String[] args) {
        boolean flag = false;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }
        s.close();
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                hash.put(nums[i], hash.get(nums[i]) + 1);
            } else {
                hash.put(nums[i], 1);
            }
        }
        for (int ele : hash.values()) {
            if (ele > 1) {
                flag = true;
                System.out.println("True");
            }
        }
        if (!flag)
            System.out.println("False");
    }
}
