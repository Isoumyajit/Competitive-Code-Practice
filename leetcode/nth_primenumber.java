import java.util.*;

public class nth_primenumber {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();

        boolean[] tempprimes = new boolean[100];
        Arrays.fill(tempprimes, true);

        tempprimes[0] = false;
        tempprimes[1] = false;

        for (int i = 2; i * i < 100; i++) {

            if (tempprimes[i])
                for (int j = i * i; j < 100; j += i) {
                    tempprimes[j] = false;
                }
        }
        int count = 0, i = 0;
        for (i = 0; i < tempprimes.length; i++) {
            if (tempprimes[i]) {
                count++;
                if (count == n)
                    break;
            }
        }
        for (int j = 0; j < tempprimes.length; j++) {
            System.out.println(j + "--->" + tempprimes[j]);
        }
        System.out.println(i);
    }
}
