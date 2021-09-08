import java.util.*;

public class oddevenSeries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] helper = new int[n + 1];
        Arrays.fill(helper, 0);
        if (n >= 1) {
            helper[0] = 0;
        }
        if (n >= 2) {
            helper[1] = 0;
        }
        if (n >= 3) {
            helper[2] = 2;
        }
        if (n >= 4) {
            helper[3] = 1;
        }
        for (int i = 4; i < n + 1; i++) {
            helper[i] = helper[i - 2] + 2;
        }
        System.out.println(helper[n - 1]);
        in.close();
    }
}
