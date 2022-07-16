public class wiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {

        int len = nums.length;
        return 1 + Math.max(calLength(nums, len, 0, 1, true), calLength(nums, len, 0, 1, false));

    }

    public static int calLength(int[] arr, int len, int preInd, int index, boolean flag) {

        if (index >= len) {
            return 0;
        }

        if (flag) {
            if (arr[index] - arr[preInd] > 0) {
                return 1 + calLength(arr, len, index, index + 1, !flag);
            } else
                return calLength(arr, len, preInd, index + 1, flag);
        } else {
            if (arr[index] - arr[preInd] < 0) {
                return 1 + calLength(arr, len, index, index + 1, !flag);
            } else
                return calLength(arr, len, preInd, index + 1, flag);
        }
    }
}