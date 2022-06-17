import java.util.Scanner;

public class maximumSubarrayOR {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int index = 0; index < len; index++)
            arr[index] = sc.nextInt();
        System.out.println(55.5 % 10);
        System.out.println(findMaxSubArrayOr(arr, len));
        sc.close();
    }

    public static int findMaxSubArrayOr(int[] arr, int len) {

        if (len == 0)
            return 0;
        else {
            int curOr = 1;
            int maxOr = Integer.MIN_VALUE;
            int start = 0;
            int end = 0;
            for (int index = 0; index < len; index++) {
                curOr |= arr[index];
                if (curOr < arr[index]) {
                    curOr = arr[index];
                    start = index;
                }
                if (maxOr < curOr) {
                    maxOr = curOr;
                    end = index;
                }
            }
            return end - start + 1;
        }
    }
}
