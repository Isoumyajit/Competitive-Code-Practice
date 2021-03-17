import java.util.*;

public class UniqueChars {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        StringBuffer answer = new StringBuffer();
        s.close();
        HashSet<Character> helper = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            helper.add(str.charAt(i));
        }
        for (Character a : helper) {
            answer.append(a);
        }

        System.out.println(answer.toString());
    }
}
