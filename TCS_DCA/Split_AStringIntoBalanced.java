import java.util.*;

public class Split_AStringIntoBalanced {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();
        // .....

        int count_L = 0, count_R = 0, Total = 0, count = 0;
        for (char a : str.toCharArray()) {
            if (a == 'R') {
                count_R++;
                count = Math.abs(count_R - count_L);
            } else {
                count_L++;
                count = Math.abs(count_R - count_L);
            }
            if (count == 0) {
                count_L = 0;
                count_R = 0;
                Total++;
            }
        }
    }
}
