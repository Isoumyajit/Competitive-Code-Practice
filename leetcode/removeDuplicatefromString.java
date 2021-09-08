import java.util.*;

public class removeDuplicatefromString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        str = str.toLowerCase();
        int hash[] = new int[26];
        Arrays.fill(hash, 0);
        int len = str.length();
        for (int i = 0; i < len; i++) {
            hash[str.charAt(i) - 97]++;
        }
        String res = "";
        for (int i = 0; i < 26; i++) {
            if (hash[i] > 0) {
                res += (char) (i + 97);
            }
        }
        System.out.println(res);
        s.close();

    }
}
