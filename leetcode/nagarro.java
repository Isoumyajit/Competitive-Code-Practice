import java.util.*;

public class nagarro {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int index = s.nextInt();
        if (index < 0) {
            System.out.println("-1");

        }
        for (int i = 1; i < str.length(); i++) {

            int freq = 0;
            if (Character.isDigit(str.charAt(i))) {
                freq = Integer.valueOf(str.charAt(i) - '0');
            }
            index -= freq;
            if (index > 0)
                continue;
            else {
                System.out.println(str.charAt(i - 1));
                break;
            }
        }
        if (index > 0) {
            System.out.println("-1");
        }
        s.close();
    }
}
