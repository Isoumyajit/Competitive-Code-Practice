/*
Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.

 go check it out ==> https://leetcode.com/problems/largest-substring-between-two-equal-characters/

Example 1:

Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.
Example 2:

Input: s = "abca"
Output: 2
Explanation: The optimal substring here is "bc".
Example 3:

Input: s = "cbzxy"
Output: -1
Explanation: There are no characters that appear twice in s.
Example 4:

Input: s = "cabbac"
Output: 4
Explanation: The optimal substring here is "abba". Other non-optimal substrings include "bb" and "".
 

Constraints:

1 <= s.length <= 300
s contains only lowercase English letters.
*/

import java.util.*;

public class LongestSubstringInBetween {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(new SolutionLongest().maxLength(str));
        s.close();
    }
}

class SolutionLongest {

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
