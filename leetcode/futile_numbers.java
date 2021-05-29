import java.util.*;

public class futile_numbers {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        int futile = 0;
        int arr_sum = 0;

        int n = s.nextInt();
        int k = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        s.close();

        for (int i = 0; i < n; i++) {
            arr_sum += arr[i];
        }

        if (arr_sum > k) {
            int[][] temp = new int[n][n];

            for (int i = 0; i < temp.length; i++) {

                int sum = 0;
                for (int j = i; j < temp[i].length; j++) {

                    sum += arr[j];
                    temp[i][j] = sum;
                }
            }

            ArrayList<Integer> helper = new ArrayList<Integer>();

            for (int i = 0; i < temp.length - 1; i++) {
                for (int j = i; j < temp[i].length; j++) {
                    if (temp[i][j] >= k) {
                        if (i + 1 != j && temp[i + 1][j - 1] < k) {
                            for (int l = i + 1; l < j; l++) {
                                if (!helper.contains(arr[l])) {
                                    helper.add(arr[l]);
                                    futile++;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(helper);
        } else if (arr_sum < k) {
            futile = n;
        }
        System.out.println(futile);

    }
}