import java.util.*;

public class all_possible_permutations {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuffer s1 = new StringBuffer();
        s1.append(s.nextLine());
        String str = s.nextLine();

        System.out.println(find_possible_permutations(str, s1, 0, s1.length() - 1));
        s.close();
    }

    public static boolean find_possible_permutations(String s1, StringBuffer str, int l, int r) {

        if (l == r) {
            if (s1.contains(str))
                return true;
            else
                return false;
        }
        for (int i = l; i <= r; i++) {
            str = swap(str, l, i);
            boolean x = find_possible_permutations(s1, str, l + 1, r);
            if (x)
                return true;
            str = swap(str, l, i);
        }
        return false;
    }

    public static StringBuffer swap(StringBuffer str, int a, int b) {

        char x = str.charAt(a);
        char y = str.charAt(b);
        str.setCharAt(a, y);
        str.setCharAt(b, x);
        return str;
    }

}
