import java.util.*;

public class Count_Number_ofConsistentString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String allowed = s.nextLine();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = s.nextLine();
        }
        System.out.println(new SolutionConsistentString().countConsistentStrings(allowed, str));
        s.close();
    }
}

class SolutionConsistentString {
    public int countConsistentStrings(String allowed, String[] words) {

        int result_count = 0, count = 0;
        ArrayList<Character> temp = new ArrayList<Character>();
        for (Character a : allowed.toCharArray()) {
            temp.add(a);
        }
        for (String str : words) {
            for (int i = 0; i < str.length(); i++) {
                if (temp.contains(str.charAt(i))) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == str.length())
                result_count++;
            count = 0;
        }
        return result_count;
    }
}