import java.util.*;

public class All_1s_are_kplacesAway {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n;
        int arr[] = new int[n = s.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        int k = s.nextInt();
        s.close();
        // main logic goes here -->

        int prev = -1;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 && !flag) {
                prev = i;
                flag = true;
            } else if (arr[i] == 1) {
                if (i - (prev + 1) >= k) {
                    prev = i;
                    flag = true;
                } else
                    return;
            }
        }
        System.out.println(flag);
    }
}
