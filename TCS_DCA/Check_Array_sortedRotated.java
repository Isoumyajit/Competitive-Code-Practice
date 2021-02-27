import java.util.*;

public class Check_Array_sortedRotated {

    public static void main(String args[]) {
        int n;
        Scanner s = new Scanner(System.in);
        int arr[] = new int[n = s.nextInt()];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        s.close();
        Solution_sorted_rotated res = new Solution_sorted_rotated();
        System.out.println(res.check(arr));
    }
}

class Solution_sorted_rotated {
    public boolean check(int[] nums) {

        int ind = 0, i = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] >= nums[i - 1])
                continue;
            else {
                ind = i;
                break;
            }
        }
        if (i == 0)
            return true;
        for (i = ind; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        for (i = 0; i < ind; i++)
            arr.add(nums[i]);

        for (i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) <= arr.get(i + 1))
                continue;
            else
                return false;
        }
        return true;
    }
}
