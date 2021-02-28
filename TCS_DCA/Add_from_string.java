import java.util.*;

public class Add_from_string {
    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int k = s.nextInt();
        s.close();
        // .........
        String str = "";
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
        }

        int number = Integer.valueOf(str);
        number += k;
        str = String.valueOf(number);
        System.out.println(number);
        for (int i = 0; i < str.length(); i++) {
            result.add(Integer.valueOf(str.charAt(i) - 48));
        }
        System.out.println(result);
    }
}
