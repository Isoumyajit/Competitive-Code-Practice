import java.util.*;

public class DCA_CommonCharsinTwoString {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String b = s.nextLine();
        s.close();
        // ......
        boolean hash[] = new boolean[26];
        Arrays.fill(hash, false);
        Set<Character> temp = new HashSet<Character>();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < a.length(); i++) {
            temp.add(a.charAt(i));
        }
        for (int i = 0; i < b.length(); i++) {
            if (temp.contains(b.charAt(i))) {
                hash[b.charAt(i) - 97] = true;
            }
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i]) {
                result.append((char) (i + 97));
            }
        }
        System.out.println(result + " " + result.reverse());
    }
}
