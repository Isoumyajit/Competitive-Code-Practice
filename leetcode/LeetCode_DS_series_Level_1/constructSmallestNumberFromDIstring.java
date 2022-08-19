public class constructSmallestNumberFromDIstring {
    public String smallestNumber(String pattern) {

        int len = pattern.length();
        String answer = "";
        int startI = 1;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            if (pattern.charAt(i) == 'I') {
                if (flag) {
                    String rev = makeReverse(startI, count);
                    count = 0;
                    flag = false;
                    answer += rev;
                } else
                    answer += startI;
                startI++;
            } else {
                flag = true;
                count++;
                startI++;
            }
        }
        if (flag)
            answer += makeReverse(startI, count);
        else
            answer += startI;
        return answer;
    }

    private static String makeReverse(int n, int k) {
        String ans = "";
        for (int i = n; i >= n - k; i--)
            ans += i;
        return ans;
    }
}
