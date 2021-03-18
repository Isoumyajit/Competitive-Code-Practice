import java.util.*;

public class LetterCombination {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();

        // .......
        List<String> lst = new ArrayList<String>();

        for (int i = 2, k = 0; i <= 9; i++) {
            String a = new String();
            if (i != 7 && i != 9) {
                a += (char) ('a' + k);
                a += (char) ('b' + k);
                a += (char) ('c' + k);
                k += 3;
            } else {
                a += (char) ('a' + k);
                a += (char) ('b' + k);
                a += (char) ('c' + k);
                a += (char) ('d' + k);
                k += 4;
            }
            lst.add(a);
        }
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
        }

        List<String> helper = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            helper.add(lst.get(Integer.valueOf(str.charAt(i) - 48) - 2));
        }
        System.out.println(helper);
        List<String> result = new ArrayList<String>();

        generateString(0, result, new StringBuffer(), helper);
        System.out.println(result);
    }

    // static int k = 0;

    public static void generateString(int i, List<String> result, StringBuffer s, List<String> helper) {

        if (i == helper.size()) {
            result.add(s.toString());
            return;
        } else {
            String curr = helper.get(i);
            for (int id = 0; id < curr.length(); id++) {
                s.append(curr.charAt(id));
                generateString(i + 1, result, s, helper);
                s.deleteCharAt(s.length() - 1);
            }
        }

    }
}
