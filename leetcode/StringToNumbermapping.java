import java.util.*;

public class StringToNumbermapping {

    public static void main(String args[]) {
        int j = 0, length = 0;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        String sk[] = s.split("#");
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                length++;
            }
        }
        for (String str : sk) {

            if (length > 0) {
                for (j = 0; j < str.length() - 2; j++) {
                    result.append((char) (str.charAt(j) - 48 + 96));
                }
                result.append(((char) (Integer.valueOf(str.substring(j, str.length())) + 96)));

                length--;
            } else {
                for (j = 0; j < str.length(); j++) {
                    result.append((char) (str.charAt(j) - 48 + 96));
                }
            }
        }
        System.out.println(result.toString());
    }
}
