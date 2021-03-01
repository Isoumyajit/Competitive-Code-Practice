import java.util.*;

public class LongestSubstringInBetween {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(new SolutionLongest().maxLengthBetweenEqualCharacters(str));
        s.close();
    }
}

class SolutionLongest {
    /*
     * Using n^2 approach Dynamic Programming Approach
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int temp[][] = new int[s.length()][s.length()];
        int index = 0, max_length = 0;
        boolean flag = false;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = 0;
            }
        }

        int length = s.length() - 1;
        for (int i = 1; i < s.length(); i++) {
            index = i;

            for (int j = 0; j < length; j++) {
                if (s.charAt(j) == s.charAt(index)) {
                    max_length = index - 1 - j;
                    flag = true;
                }
                index++;
            }
            length--;
        }
        if (flag)
            return max_length;
        return -1;
    }

    /*
     * Second Method more Optimized using hashing with Arrays --->
     */
    public int maxLength(String s) {
        int hash[] = new int[26];
        s = s.toLowerCase();
        int answer = 0;
        boolean flag = false;
        Arrays.fill(hash, -1);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (hash[s.charAt(i) - 97] == -1) {
                hash[s.charAt(i) - 97] = i;
            } else {
                flag = true;
                answer = Math.max(answer, hash[s.charAt(i) - 97] - 1 - i);
            }
        }
        if (!flag)
            return -1;
        return answer;
    }
}
