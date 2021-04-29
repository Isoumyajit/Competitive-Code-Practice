import java.util.*;

public class string_minimization_tiasha {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();

        if (str.length() == 1)
            System.out.println(1);
        else
            System.out.println(check_recursively(str, 0, str.length() - 1));
    }

    public static int check_recursively(String str, int a, int b) {

        int i, j;
        if (a == b) {
            return 1;
        }
        if (str.charAt(a) != str.charAt(b)) {
            return b - a + 1;
        }
        for (i = a; i < b;) {
            if (str.charAt(i) == str.charAt(b)) {
                i++;
            } else {
                break;
            }
        }
        for (j = b; j > i;) {
            if (str.charAt(j) == str.charAt(a)) {
                j--;
            } else {
                break;
            }
        }
        return check_recursively(str, i, j);
    }
}
