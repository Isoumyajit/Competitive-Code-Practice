import java.util.*;

public class DCA_Practice_q1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            if (i != str.length() - 1 && str.charAt(i) == '5' && str.charAt(i + 1) == '3') {
                i++;
                continue;
            } else if (str.charAt(i) == '8') {
                continue;
            } else if (!((str.charAt(i) >= 48 && str.charAt(i) <= 57) || (str.charAt(i) >= 65 && str.charAt(i) <= 91)
                    || (str.charAt(i) >= 97 && str.charAt(i) <= 122))) {
                System.out.println("Error");
                return;
            } else {
                result.append(str.charAt(i));
            }
        }
        System.out.println(result.toString().toLowerCase());
    }
}