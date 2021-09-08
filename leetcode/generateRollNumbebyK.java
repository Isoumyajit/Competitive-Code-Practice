import java.util.*;

public class generateRollNumbebyK {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long x = s.nextLong();
        int key = s.nextInt();
        String helper = String.valueOf(x);

        if (key > helper.length())
            key = (helper.length()) % key;

        for (int i = key - 1; i < helper.length(); i++) {
            System.out.print(helper.charAt(i));
        }
        for (int i = 0; i < key - 1; i++) {
            System.out.print(helper.charAt(i));
        }
        s.close();
    }
}
