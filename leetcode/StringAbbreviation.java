import java.util.*;

public class StringAbbreviation {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        // .....

        StringBuffer result = new StringBuffer();
        int count = 0;
        String helper[] = str.split(" ");
        count = helper.length;
        for (String a : helper) {

            if (count > 1) {
                result.append(a.toUpperCase().charAt(0));
                result.append(".");
                count--;
            } else {
                result.append(a);
            }
        }
        System.out.println(result);
    }
}
