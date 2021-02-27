/*

link ===> https://leetcode.com/problems/longest-substring-without-repeating-characters/
Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

import java.util.*;

public class LongstSubStringWithoutRepeate {

    public static void main(String args[]) {

        int maxlength = 0;
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();
        ArrayList<Character> temp = new ArrayList<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (temp.contains(str.charAt(i))) {
                if (maxlength < temp.size()) {
                    maxlength = temp.size();
                }
                int index = temp.indexOf(str.charAt(i));
                int no_of_times = index - 0 + 1;
                for (int j = 1; j <= no_of_times; j++) {
                    temp.remove(0);
                }
            }
            temp.add(str.charAt(i));
        }
        if (maxlength < temp.size()) {
            maxlength = temp.size();
        }
        System.out.println(maxlength);
    }
}
