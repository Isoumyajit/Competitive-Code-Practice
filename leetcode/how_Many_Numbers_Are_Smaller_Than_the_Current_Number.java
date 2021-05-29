import java.util.*;

public class how_Many_Numbers_Are_Smaller_Than_the_Current_Number {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int[] helper = new int[101];
        int[] sum = new int[101];
        Arrays.fill(helper, 0);
        Arrays.fill(sum, 0);
        for (int i = 0; i < n; i++) {
            helper[arr[i]]++;
        }
        sum[0] = helper[0];
        for (int i = 1; i < 101; i++) {
            sum[i] = sum[i - 1] + helper[i];
        }

        for (int i = 0; i < arr.length; i++) {
            result[i] = sum[arr[i]] - helper[arr[i]];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(result[i] + " ");
        }
        s.close();
    }
}
