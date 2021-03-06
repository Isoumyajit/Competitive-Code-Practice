
/**
 Write a program to Validate an IPv4 Address. According to Wikipedia, IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots, e.g., 172.16.254.1 . The generalized form of an IPv4 address is (0-255).(0-255).(0-255).(0-255). Here we are considering numbers only from 0 to 255 and any additional leading zeroes will be considered invalid.

Your task is  to complete the function isValid which returns 1 if the ip address is valid else returns 0. The function takes a string s as its only argument .

Example 1:

Input:
ip = 222.111.111.111
Output: 1
Example 2:

Input:
ip = 5555..555
Output: 0
Explanation: 5555..555 is not a valid
ip address, as the middle two portions
are missing.
Your Task:
Complete the function isValid() which takes the string s as an input parameter and returns 1 if this is a valid ip address otherwise returns 0.

Expected Time Complexity: O(N), N = length of string.
Expected Auxiliary Space: O(1)

Constraints:
1<=length of string <=50

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code. */

import java.util.*;

public class validateIpAdress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution_validateIpAdress obj = new Solution_validateIpAdress();

            if (obj.isValid(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
        sc.close();
    }
}

class Solution_validateIpAdress {

    public boolean isValid(String s) {
        // Write your code here
        boolean result = false;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.')
                cnt++;
            if (cnt > 3)
                return false;
        }
        StringTokenizer helper = new StringTokenizer(s, ".");
        if (helper.countTokens() < 4 || helper.countTokens() > 4)
            return result;
        while (helper.hasMoreTokens()) {
            String temp = helper.nextToken();
            if (temp.length() == 0 || !isNumeric(temp) || temp.length() > 3) {
                return result;
            }

            long value = Long.parseLong(temp);
            if (value < 10 && temp.length() > 1)
                return result;
            if (value < 0)
                return result;
            if (!(value >= 0 && value <= 255)) {
                return result;
            }
        }
        return !result;
    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
}