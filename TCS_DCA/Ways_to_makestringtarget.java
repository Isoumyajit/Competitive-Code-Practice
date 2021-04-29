import java.util.*;

public class Ways_to_makestringtarget {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String target = s.nextLine();
        s.close();

        // .....

        int count = 0;
        int hash[] = new int[26];
        Arrays.fill(hash, 0);
        target = target.toLowerCase();
        str = str.toLowerCase();
        for (int i = 0; i < target.length(); i++) {
            hash[target.charAt(i) - 97]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (hash[str.charAt(i) - 97] > 0) {
                hash[str.charAt(i) - 97]--;
            }
        }

    }
}
