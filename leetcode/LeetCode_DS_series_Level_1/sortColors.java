import java.util.Arrays;
import java.util.Scanner;

public class sortColors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] usergiven = new int[n];
        for (int i = 0; i < n; i++) {
            usergiven[i] = sc.nextInt();
        }
        sc.close();

    }

}

class SolutionSortColors {
    public static void sortColors(int[] nums) {
        int len = nums.length;
        int[] helper = new int[3];
        Arrays.fill(helper, 0);
        for (int val : nums) {
            helper[val]++;
        }
        for (int i = 0, counter = 0; i < len;) {
            if (helper[counter] > 0) {
                if (nums[i] == counter) {
                    helper[counter]--;
                } else {
                    helper[counter]--;
                    nums[i] = counter;
                }
                if (helper[counter] == 0)
                    counter++;
                i++;
            } else
                counter++;
        }
    }
}