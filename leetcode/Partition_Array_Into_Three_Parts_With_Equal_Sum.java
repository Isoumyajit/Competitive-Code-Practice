import java.util.*;

public class Partition_Array_Into_Three_Parts_With_Equal_Sum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int n = input.length();
        String temp = "";
        int j = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {

            if (input.charAt(i) == ',') {
                arr[j++] = Integer.valueOf(temp);
                temp = "";
                continue;
            }
            temp += input.charAt(i);
        }
        System.out.println(canThreePartsEqualSum(arr));
        s.close();
    }

    public static boolean canThreePartsEqualSum(int[] arr) {

        int i, sum = 0, n = arr.length;
        int current_sum = 0;
        int count_pair = 0;
        int zero_cnt = 0;
        int zero_pair = 0;
        for (i = 0; i < n; i++) {
            sum += arr[i];
            if (arr[i] == 0) {
                zero_cnt++;
            }
            if (sum == 0) {
                zero_pair++;
            }
        }
        if (zero_cnt == arr.length)
            return true;
        if (zero_pair != 0 && n % zero_pair == 0 && zero_pair > 3)
            return true;
        System.out.println(sum);
        for (i = 0; i < n; i++) {
            current_sum += arr[i];
            if (current_sum == sum / 3 && count_pair < 3) {
                current_sum = 0;
                count_pair++;
            }
        }
        if (count_pair == 3)
            return true;
        return false;
    }
}
