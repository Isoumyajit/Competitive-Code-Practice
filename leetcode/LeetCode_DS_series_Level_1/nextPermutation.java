import java.util.Scanner;

public class nextPermutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int index = 0; index < n; index++)
            arr[index] = sc.nextInt();
        for (int index = 0; index < n; index++)
            System.out.print(arr[index] + " ");
        sc.close();
    }
}

class SolutionNextpermutation {
    public void nextPermutation(int[] nums) {

        int lastIndex = -1;
        int len = nums.length;
        for (int index = 0; index < len; index++) {
            if (nums[index] < nums[index + 1]) {
                lastIndex = index;
            }
        }
        if (lastIndex == -1) {
            for (int index = 0; index < len / 2; index++) {
                swap(nums, index, len - index - 1);
            }

        } else {
            int indexLeft = -1;
            for (int index = lastIndex + 1; index < len; index++) {
                if (nums[lastIndex - 1] < nums[index]) {
                    indexLeft = index;
                }
            }
            if (indexLeft == -1) {
                swap(nums, lastIndex, lastIndex - 1);
            } else
                swap(nums, lastIndex - 1, indexLeft);
            for (int index = lastIndex, right = len - 1; index < right; index++, right--)
                swap(nums, index, right);
        }

    }

    private static void swap(int[] nums, int a, int b) {
        nums[a] += nums[b];
        nums[b] = nums[a] - nums[b];
        nums[a] = nums[a] - nums[b];
    }
}
