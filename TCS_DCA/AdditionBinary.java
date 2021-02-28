import java.util.*;

public class AdditionBinary {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        StringBuffer a = new StringBuffer();
        a.append(s.nextLine());
        StringBuffer b = new StringBuffer();
        char carry = '0';
        StringBuffer result = new StringBuffer();
        b.append(s.nextLine());
        s.close();
        a = a.reverse();
        b = b.reverse();
        int min = Math.min(a.length(), b.length());
        int max = Math.max(a.length(), b.length());
        int i = 0;
        for (i = 0; i < min; i++) {
            if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                if (carry == '0') {
                    result.append('0');
                    carry = '1';
                } else {
                    result.append('1');
                    carry = '1';
                }
            } else if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                if (carry == '0') {
                    result.append('0');
                } else {
                    result.append('1');
                    carry = '0';
                }
            } else if (a.charAt(i) == '1' && b.charAt(i) == '0') {
                if (carry == '1') {
                    result.append('0');
                    carry = '1';
                } else {
                    result.append('1');
                }
            } else if (a.charAt(i) == '0' && b.charAt(i) == '1') {
                if (carry == '1') {
                    result.append('0');
                    carry = '1';
                } else {
                    result.append('1');
                }
            }
        }
        if (a.length() == i) {

            for (; i < max; i++) {
                if (b.charAt(i) == '1') {
                    if (carry == '1') {
                        result.append('0');
                        carry = '1';
                    } else {
                        result.append('1');
                        carry = '0';
                    }
                } else {
                    if (carry == '1') {
                        result.append('1');
                        carry = '0';
                    } else {
                        result.append('0');
                        carry = '0';
                    }
                }
            }
        } else {
            for (; i < max; i++) {
                if (a.charAt(i) == '1') {
                    if (carry == '1') {
                        result.append('0');
                        carry = '1';
                    } else {
                        result.append('1');
                        carry = '0';
                    }
                } else {
                    if (carry == '1') {
                        result.append('1');
                        carry = '0';
                    } else {
                        result.append('0');
                        carry = '0';
                    }
                }
            }
        }
        if (carry == '1')
            result.append('1');
        result = result.reverse();
        System.out.println(result);

    }
}
