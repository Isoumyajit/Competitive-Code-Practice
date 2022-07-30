import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class longestPalindrimincSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(SolutionLongestPalindrimicSubstring.findlongestpalindrome(str));
        sc.close();
    }
}

class SolutionLongestPalindrimicSubstring {
    public static String findlongestpalindrome(String str) {
        int len = str.length();

        if (len == 0)
            return "";
        else if (len == 1) {
            return str;
        }
        String answer = "";

        int index_count = 2;
        int start = -1;
        int end = -1;

        int[][] mat = new int[len][len];
        for (int i = 0; i < len; i++) {
            mat[i][i] = 1;
        }
        for (int i = 0, j = 1; j < len; i++, j++) {
            if (str.charAt(i) == str.charAt(j)) {
                mat[i][j] = 1;
                start = i;
                end = j;
            }
            

        while (index_count < len) {

            for ( i = 0, j = index_count; j < len; i++, j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (mat[i + 1][j - 1] == 1) {
                        mat[i][j] = 1;
                        start = i;
                        end = j;
                    } else {
                        mat[i][j] = 0;
                    }
                } else {
                    mat[i][j] = 0;
                }

            }
            index_count++;
        }

        if (start == -1 && end == -1) {
            answer += str.charAt(0);
        } else {
            for (i = start; i < end + 1; i++) {
                answer += str.charAt(i);
            }
        }
        return answer;
    }
}
