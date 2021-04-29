
import java.util.*;

public class seive {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();

        boolean[] seive_check = new boolean[n];
        Arrays.fill(seive_check, true);
        check_prime(seive_check);

        for (int i = 0; i < seive_check.length; i++) {
            if (seive_check[i])
                System.out.print(i + " ");
        }

    }

    public static void check_prime(boolean arr[]) {

        int p = arr.length - 1;
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i * i < p; i++) {

            if (arr[i] == true) {
                for (int j = i * i; j < p; j += i) {
                    arr[j] = false;
                }
            }
        }
    }

}
