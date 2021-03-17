import java.util.*;

public class String_ZIGZAG {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int numRows = s.nextInt();
        s.close();
        // .......
        StringBuffer result = new StringBuffer();
        int col = 0;
        if (str.length() % 2 == 1) {
            col = str.length() / 2 + 1;
        } else {
            col = str.length() / 2;
        }
        char helper[][] = new char[numRows][col];

        if (numRows == 1) {
            for (int i = 0; i < str.length(); i++) {
                result.append(str.charAt(i));
            }
        } else {
            int k = 0, i, j;
            for (i = 0; i < numRows; i++) {
                for (j = 0; j < col; j++) {
                    helper[i][j] = ' ';
                }
            }
            for (i = 0; i < col; i++) {
                for (j = 0; j < numRows && k < str.length(); j++) {
                    helper[j][i] = str.charAt(k);
                    k++;
                    // System.out.println(str.charAt(k) + " " + k);
                }
                for (j = j - 2; j > 0 && k < str.length(); j--) {
                    // System.out.println(str.charAt(k) + " " + k);
                    helper[j][i + 1] = str.charAt(k);
                    k++;
                    i++;
                }
                if (k >= str.length())
                    break;
            }

            for (i = 0; i < numRows; i++) {
                for (j = 0; j < col; j++) {
                    if (helper[i][j] != ' ')
                        result.append(helper[i][j]);
                }
            }
            System.out.println(result.toString());
        }
    }
}
