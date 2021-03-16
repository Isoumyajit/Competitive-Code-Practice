import java.util.*;

public class MavenTic_problemOddNumber {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // ....
        int number = 0;
        int Max_Odd = Integer.MIN_VALUE;
        String str = sc.nextLine();
        for (int i = 0; i < str.length() - 3; i++) {
            number = Integer.valueOf(str.substring(i, i + 3));
            if (number % 2 == 1) {
                Max_Odd = Math.max(Max_Odd, number);
            }
        }
        System.out.println(Max_Odd);
        sc.close();
    }
}
