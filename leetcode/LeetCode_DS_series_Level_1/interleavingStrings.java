
import java.util.Scanner;

public class interleavingStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        System.out.println(isInterleave(s1, s2, s3));
        sc.close();

    }

    public static boolean isInterleave(String s1, String s2, String s3) {

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 == 0 && len2 == 0 && len3 == 0)
            return true;

        return (isPossible(0, 0, s1, s2, s3, 0, s3.length(), true)
                | isPossible(0, 0, s1, s2, s3, 0, s3.length(), false));
    }

    public static boolean isPossible(int start, int start1, String s1, String s2, String s3, int index, int len,
            boolean flag) {

        if (index == len) {
            if (start1 == s2.length() && start == s1.length())
                return true;
            return false;
        }

        if (flag) {

            for (int i = start; i < s1.length(); i++) {
                String x = s1.substring(start, i + 1);
                if (!(x.length() + index <= s3.length()))
                    return false;

                if (x.length() + index <= s3.length() && x.equals(s3.substring(index, index + x.length()))) {
                    if (isPossible(i + 1, start1, s1, s2, s3, index + x.length(), len, !flag))
                        return true;
                } else
                    return false;
            }
            return false;
        } else {

            for (int i = start1; i < s2.length(); i++) {
                String x = s2.substring(start1, i + 1);
                if (!(x.length() + index <= s3.length()))
                    return false;

                if (x.length() + index <= s3.length() && x.equals(s3.substring(index, index + x.length()))) {
                    if (isPossible(start, i + 1, s1, s2, s3, index + x.length(), len, !flag))
                        return true;
                } else
                    return false;
            }
            return false;
        }
    }

    /*
     * Dynamic programming Approach - 1 Memoraization + recursion
     */
    public static boolean isInterleavewithDP(String s1, String s2, String s3) {

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 == 0 && len2 == 0 && len3 == 0)
            return true;
        if (len1 + len2 != len3)
            return false;
        Boolean[][] visited = new Boolean[len1 + 1][len2 + 1];
        return isPossible(0, 0, s1, s2, s3, 0, s3.length(), visited);

    }

    public static boolean isPossible(int start, int start1, String s1, String s2, String s3, int index, int len,
            Boolean[][] visited) {

        if (index == len) {
            if (start1 == s2.length() && start == s1.length())
                return true;
            return false;
        }
        if (visited[start][start1] != null)
            return visited[start][start1];
        if (start < s1.length() && s1.charAt(start) == s3.charAt(start + start1)) {
            boolean ans1 = isPossible(start + 1, start1, s1, s2, s3, index + 1, len, visited);
            visited[start][start1] = ans1;
            if (ans1)
                return true;
        }
        if (start1 < s2.length() && s2.charAt(start1) == s3.charAt(start + start1)) {
            boolean ans2 = isPossible(start, start1 + 1, s1, s2, s3, index + 1, len, visited);
            visited[start][start1] = ans2;
            if (ans2)
                return true;
        }

        return false;
    }

    /*
     * Dynamic Programming Approach -2 Tabulation
     */
    public static boolean isInterleavewithDP2(String s1, String s2, String s3) {

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 == 0 && len2 == 0 && len3 == 0)
            return true;
        if (len1 + len2 != len3)
            return false;
        Boolean[][] visited = new Boolean[len1 + 1][len2 + 1];

        for (int row = 0; row < visited.length; row++) {
            for (int col = 0; col < visited[0].length; col++) {
                if (row == 0 && col == 0)
                    visited[row][col] = true;
                else if (row == 0) {
                    if (s3.charAt(row + col - 1) == s2.charAt(col - 1))
                        visited[row][col] = visited[row][col - 1];
                } else if (col == 0) {
                    if (s3.charAt(row + col - 1) == s1.charAt(row - 1))
                        visited[row][col] = visited[row - 1][col];
                } else {
                    if (s3.charAt(row + col - 1) == s2.charAt(col - 1)) {
                        visited[row][col] = visited[row][col - 1];
                    } else if (s3.charAt(row + col - 1) == s1.charAt(row - 1)) {
                        visited[row][col] = visited[row - 1][col];
                    }
                }
            }
        }
        return visited[visited.length - 1][visited[0].length - 1];
    }

}
