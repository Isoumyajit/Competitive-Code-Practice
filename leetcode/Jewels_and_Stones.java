import java.util.*;

public class Jewels_and_Stones {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String jewels = s.nextLine();
        String stones = s.nextLine();
        int count = 0;
        s.close();
        ArrayList<Character> helper = new ArrayList<Character>();
        for (int i = 0; i < jewels.length(); i++) {
            helper.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if (helper.contains(stones.charAt(i))) {
                count++;
            }
        }
        System.out.println(count);
        String sk[] = jewels.split(stones, '&');
    }
}
