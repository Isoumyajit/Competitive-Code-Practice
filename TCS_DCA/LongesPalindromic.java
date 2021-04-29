import java.util.*;

public class LongesPalindromic {
    public static void main(String args[]) {

        int start = 0, end = 0, length = 0;
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int temp[][] = new int[str.length()][str.length()];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (i == j) {
                    temp[i][j] = 1;
                } else {
                    temp[i][j] = 0;
                }
            }
        }
        length = str.length() - 1;
        for (int i = 1; i < str.length(); i++) {
            int index = i;
            for (int j = 0; j < length; j++) {
                if (str.charAt(index) == str.charAt(j)) {
                    if (temp[j + 1][index - 1] == 1 || index == j + 1) {
                        start = j;
                        end = index;
                        temp[j][index++] = 1;
                    } else {
                        temp[j][index++] = 0;
                    }
                } else {
                    temp[j][index++] = 0;
                }
            }
            length--;
        }
        for (int i = start; i <= end; i++) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
        s.close();
    }
}
