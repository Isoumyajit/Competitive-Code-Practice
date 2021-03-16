import java.util.*;

public class Find_MultiplicationFactors {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();
        if (n < 10) {
            System.out.println(10 + n);
        } else if (n >= 10) {
            StringBuffer result = new StringBuffer();
            for (int i = 9; i > 1; i--) {
                while (n % i == 0) {
                    n = n / i;
                    result.append(String.valueOf(i));
                }
                if (n == 1)
                    break;
            }
            if (n == 1)
                System.out.println(result.reverse());
            else
                System.out.println("Not Possible");
        }
    }
}
