
import java.util.*;

public class DCA_practice_LongestString {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();
        int start = 0, maxlength = 0, length = 0, index = 0, i = 0;
        if (str.length() == 0) {
            System.out.println("No String ");
            return;
        }
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                length = i - index;
                if (maxlength < length) {
                    maxlength = length;
                    start = i - length;
                }
                index = i + 1;
            }
        }
        length = (i - 1) - index;
        if (maxlength < length) {
            maxlength = length;
            start = i - length;
        }
        for (i = start - 1; i < start + maxlength; i++) {
            System.out.print(str.charAt(i));
        }
    }
}
