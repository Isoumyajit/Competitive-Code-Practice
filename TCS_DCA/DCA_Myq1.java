import java.util.*;

public class DCA_Myq1 {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                count++;
            }
        }
        if (count == arr.length - 1) {
            System.out.println("-1");
        } else {
            int max = Arrays.stream(arr).max().getAsInt();
            int hash[] = new int[max + 1];
            Arrays.fill(hash, 0);

            for (int i = 0; i < n; i++) {
                hash[arr[i]]++;
            }
            int min = Integer.MAX_VALUE;
            int low = arr[0];

            for (int i = 0; i < n; i++) {
                if (hash[arr[i]] < min) {
                    min = hash[arr[i]];
                    low = arr[i];
                }
            }
            System.out.println(low);
        }
    }
}
