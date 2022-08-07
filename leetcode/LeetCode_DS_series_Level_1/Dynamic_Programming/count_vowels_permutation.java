package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private static Map<Character, ArrayList<Character>> map = new HashMap<>();
    private static char[] temp = { 'a', 'e', 'i', 'o', 'u' };
    private static int mod = 1000000007;

    Solution() {
        for (char a : temp) {
            map.put(a, new ArrayList<>());
        }
        map.get('a').add('e');
        map.get('e').addAll(Arrays.asList('a', 'i'));
        map.get('i').addAll(Arrays.asList('a', 'e', 'o', 'u'));
        map.get('o').addAll(Arrays.asList('i', 'u'));
        map.get('u').add('a');
    }

    public int countVowelPermutation(int n) {

        int count = 0;
        int[][] dp = new int[26][n + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        for (char x : temp) {
            count = count % mod + countPossibilities(n - 1, x, dp) % mod;
        }
        return count % mod;
    }

    private static int countPossibilities(int n, char x, int[][] dp) {

        if (n == 0)
            return 1;
        long count = 0;
        if (dp[x - 'a'][n] != -1)
            return dp[x - 'a'][n] % mod;
        ArrayList<Character> helper = map.get(x);
        for (char c : helper) {
            count = count % mod + countPossibilities(n - 1, c, dp) % mod;
        }
        return dp[x - 'a'][n] = (int) count % mod;

    }
}