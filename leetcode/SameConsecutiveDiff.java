import java.util.*;

public class SameConsecutiveDiff {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

        s.close();

        // .....
        List<String> result = new ArrayList<String>();
        for (int i = 1; i <= 9; i++) {
            String str = new String(String.valueOf(i));
            findList(result, i, n, k, str);
        }
        List<Integer> answer = new ArrayList<Integer>();
        for (String a : result) {
            if (a.length() == n) {
                answer.add(Integer.valueOf(a));
            }
        }
        System.out.println(answer);
    }

    public static void findList(List<String> result, int digit, int n, int k, String str) {

        if (n == 1) {
            if (!result.contains(str))
                result.add(str);
            return;
        }
        if (digit + k < 10) {
            System.out.println(str);
            findList(result, digit + k, n - 1, k, str + String.valueOf(digit + k));
        }
        if (digit - k >= 0) {
            findList(result, digit - k, n - 1, k, str + String.valueOf(digit - k));
        }

    }
}
