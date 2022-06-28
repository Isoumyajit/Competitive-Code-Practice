import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class minimumDeletiontoMakecharFrequnique {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(minDeletions_sortApproach(str));
        sc.close();
    }

    /*
     * Approach - 1
     * 
     * Here I use a Set of size 26 maximum and an Array of 26 to count the
     * frequencies of chars
     * 
     */
    public static int minDeletions(String s) {

        int len = s.length();
        int count = 0;
        if (len == 0 || len == 1)
            return 0;

        int[] hash = new int[26];

        Set<Integer> helper = new HashSet<>();
        for (int index = 0; index < s.length(); index++) {
            hash[s.charAt(index) - 'a']++;
        }

        for (int index = 0; index < 26; index++) {
            if (hash[index] != 0 && !helper.contains(hash[index])) {
                helper.add(hash[index]);
            } else if (hash[index] != 0) {
                while (helper.contains(hash[index])) {
                    hash[index]--;
                    count++;
                }
                if (hash[index] != 0)
                    helper.add(hash[index]);
            }
        }
        return count;
    }

    public static int minDeletions_sortApproach(String s) {

        int len = s.length();
        int count = 0;
        if (len == 0 || len == 1)
            return 0;

        int[] hash = new int[26];

        for (int index = 0; index < s.length(); index++) {
            hash[s.charAt(index) - 'a']++;
        }

        Arrays.sort(hash);
        int curVal = len;
        for (int index = 25; index >= 0 && hash[index] > 0; index--) {
            if (hash[index] != 0) {
                if (curVal < hash[index]) {
                    count += hash[index] - curVal;
                    hash[index] = curVal;
                }
                curVal = Math.max(0, hash[index] - 1);
            }
        }
        return count;

    }
}
