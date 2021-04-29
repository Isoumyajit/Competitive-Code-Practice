import java.util.*;

public class DCA_20thq1_shift2 {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();
        // ....
        long sum = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length() - i; j++) {
                System.out.print(str.substring(j, j + i + 1) + " ");
                sum += Long.valueOf((str.substring(j, j + i + 1)));
            }
        }
        System.out.println(sum);
    }
}
s