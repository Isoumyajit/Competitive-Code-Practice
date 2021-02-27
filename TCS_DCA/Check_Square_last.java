import java.util.*;

public class Check_Square_last {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        s.close();
        if (n < 0)
            return;
        String check = String.valueOf(n);
        String str = String.valueOf(n * n);

        System.out.println(check + " " + str + " " + str.endsWith(check));
    }
}
