import java.util.*;

public class Niladri {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String value = String.valueOf(n);
        System.out.println(value.charAt(0) + " " + value.charAt(value.length() - 1));
    }
}
