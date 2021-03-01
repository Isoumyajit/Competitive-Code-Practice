import java.util.*;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        s.close();
        // ...........
        StringBuffer result = new StringBuffer();
        String temp[] = input.split(" ");
        for (String a : temp) {
            result.append(new StringBuffer(a).reverse());
            result.append(' ');
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result);

    }
}
