
/*

ref ==> https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: 
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: 
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 

Note:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
All strings contain lowercase English letters only.

*/
import java.util.*;

class Find_Words_That_Can_Be_Formed_by_Characters {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLine();
        }

        String temp = s.nextLine();

        Solution_Find obj = new Solution_Find();
        System.out.print(obj.countCharacters(arr, temp));
        s.close();
    }

}

class Solution_Find {
    public int countCharacters(String[] words, String chars) {

        int i = 0, len = chars.length();
        int sum_len = 0, cnt = 0;

        int hash[] = new int[26];
        int temp[] = new int[26];

        Arrays.fill(hash, 0);
        for (i = 0; i < len; i++) {
            hash[chars.charAt(i) - 97]++;
        }

        for (i = 0; i < words.length; i++) {

            sum_len = 0;
            temp = hash.clone();
            for (int j = 0; j < words[i].length(); j++) {

                if (temp[words[i].charAt(j) - 97] == 0) {
                    break;
                } else {
                    sum_len += 1;
                    temp[words[i].charAt(j) - 97]--;
                }

            }

            if (words[i].length() == sum_len) {
                cnt += sum_len;
            }
        }
        return cnt;

    }
}
