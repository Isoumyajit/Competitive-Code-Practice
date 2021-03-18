/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/

import java.util.*;

public class generatepranthesis {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // ......
        String str = "(";
        List<String> result = new ArrayList<String>();
        generatebracket(result, str.toString(), 1, 0, n);
        System.out.println(result);
    }

    public static void generatebracket(List<String> result, String str, int open, int close, int n) {

        if (str.length() == n * 2) {
            result.add(str);
            return;
        }
        if (open < n) {
            generatebracket(result, str + "(", open + 1, close, n);
        }
        if (close < open) {
            generatebracket(result, str + ")", open, close + 1, n);
        }
    }

}