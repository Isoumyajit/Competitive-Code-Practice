import java.util.*;

public class DCA20thq1 {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();

        if (n < 0) {
            System.out.println("Wrong Input");
            return;
        }
        long power = (long) Math.pow(n, 4);
        String str = String.valueOf(n);
        String str1 = String.valueOf(power);
        s.close();
        if (str1.endsWith(str)) {
            System.out.println("True- Power of 4 for number " + n + " is " + str1);
        } else {
            System.out.println("Power of 4 for number " + n + " is " + str1);
        }
    }
}
