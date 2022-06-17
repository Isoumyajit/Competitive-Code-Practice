import java.util.Scanner;

public class countTotalpalindrimicSubstrings {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(SolutiongetCount.totalPalindrimicSubstring(str));
        sc.close();
    }
}

class SolutiongetCount {

    public static int totalPalindrimicSubstring(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        else if (len == 1)
            return 1;

        int[][] helper = new int[len][len];
        int palCount = len;
        for (int index = 0; index < len; index++)
            helper[index][index] = 1;

        for (int length = 1; length < len; length++) {
            for (int index = 0, colIndex = length; index < len && colIndex < len; colIndex++, index++) {
                if (s.charAt(index) == s.charAt(colIndex)) {
                    if (length != 1 && helper[index + 1][colIndex - 1] == 1) {
                        helper[index][colIndex] = 1;
                        palCount++;
                    } else if (length == 1) {
                        helper[index][colIndex] = 1;
                        palCount++;
                    }
                }
            }
        }
        return palCount;
    }
}
