import java.util.*;

public class Fibbonacci_Sequence {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();

        // .....
        double helper = (1 + Math.sqrt(5)) / 2;
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i <= n; i++) {
            result.add(String.valueOf(Math.round(Math.pow(helper, i) / Math.sqrt(5))));
        }
        System.out.println(result);
    }
}
