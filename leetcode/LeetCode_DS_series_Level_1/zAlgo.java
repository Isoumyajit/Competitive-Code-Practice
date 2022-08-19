import java.util.*;

public class zAlgo {

    public static void main(String[] args) {

    }

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();
        String str1 = "";
        String str2 = "";
        StringBuffer one = new StringBuffer();
        StringBuffer two = new StringBuffer();
        for (String t : words) {
            str1 += t;
        }
        for (int i = words.length - 1; i >= 0; i--) {
            str2 += words[i];
        }
        one.append(str1 + "$");
        two.append(str2 + "$");
        one.append(s);
        two.append(s);
        findIndexes(one, ans);
        findIndexes(two, ans);

        return ans;
    }

    private static void findIndexes(StringBuffer s, List<Integer> ans) {

        int[] z = findZindex(s);
        int len = s.length();
        for (int i = 0; i < z.length; i++) {
            if (z[i] == len) {
                ans.add(i - (len + 1));
            }
        }
    }

    private static int[] findZindex(StringBuffer s) {
        int len = 0;
        int[] z = new int[len = s.length()];
        int first = 0;
        int last = 0;
        for (int i = 1; i < len; i++) {

            if (i < first) {
                first = last = i;
                while (last < s.length() && s.charAt(last) == s.charAt(last - first)) {
                    last++;
                }
                z[i] = last - first;
                last--;
            } else {
                int index = i - first;
                if (z[index] < last - i + 1) {
                    z[i] = z[index];
                } else {
                    first = i;
                    while (last < s.length() && s.charAt(last) == s.charAt(last - first)) {
                        last++;
                    }
                    z[i] = last - first;
                    last--;
                }
            }
        }

        return z;
    }
}
