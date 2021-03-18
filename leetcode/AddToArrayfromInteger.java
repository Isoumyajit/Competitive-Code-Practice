import java.util.*;

public class AddToArrayfromInteger {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        int k = s.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        s.close();

        // .....
        System.out.println(new Solution_summation_Array().addToArrayForm(arr, k));
    }
}

class Solution_summation_Array {
    public List<Integer> addToArrayForm(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        String str = String.valueOf(k);
        int element[] = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            element[i] = Integer.valueOf(str.charAt(i) - 48);
        }

        int carry = 0;
        int sum = 0;
        int i, cnt;

        for (i = arr.length - 1, cnt = element.length - 1; i >= 0; i--, cnt--) {

            if (cnt >= 0) {
                sum = arr[i] + element[cnt];
                if (carry > 0)
                    sum += carry;
                result.add(sum % 10);
                carry = sum / 10;
                sum = 0;
            } else {
                if (carry > 0)
                    sum = arr[i] + carry;
                else {
                    sum = arr[i] + 0;
                }
                result.add(sum % 10);
                carry = sum / 10;
            }
        }
        sum = 0;

        for (; cnt >= 0; cnt--) {
            if (carry > 0)
                sum = element[cnt] + carry;
            else {
                sum = element[cnt] + 0;
            }
            result.add(sum % 10);
            carry = sum / 10;

        }
        if (carry > 0)
            result.add(carry);
        Collections.reverse(result);
        return result;
    }
}
