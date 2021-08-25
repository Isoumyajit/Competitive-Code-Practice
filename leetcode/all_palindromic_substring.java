import java.util.*;

public class all_palindromic_substring {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();

        ///////////// ***** all Plaindromic string logic starts here *******/////////

        all_palindromes obj = new all_palindromes(str);
        // ArrayList<String> answer = new ArrayList<String>();
        System.out.println(obj.palindrome());
    }
}

class all_palindromes {

    private String str;

    all_palindromes(String str) {
        this.str = str;
    }

    ArrayList<String> palindrome() {

        ArrayList<String> answer = new ArrayList<String>();
        int[][] temp = new int[str.length()][str.length()];
        for (int i = 0; i < temp.length; i++) {

            for (int j = 0; j < temp[i].length; j++) {
                if (i == j) {
                    temp[i][j] = 1;
                    if (!answer.contains(String.valueOf(str.charAt(i)))) {
                        answer.add(String.valueOf(str.charAt(i)));
                    }
                } else {
                    temp[i][j] = 0;
                }
            }
        }

        int length = str.length() - 1;
        for (int i = 1; i < str.length(); i++) {

            int index = i;

            for (int j = 0; j < length; j++) {

                if (str.charAt(index) == str.charAt(j)) {
                    if (index == j + 1 || temp[j + 1][index - 1] == 1) {
                        if (!answer.contains(str.substring(j, index + 1))) {
                            answer.add(str.substring(j, index + 1));
                            temp[j][index++] = 1;
                        }
                    } else
                        index++;
                } else
                    index++;
            }
            length--;
        }
        return answer;
    }
}
