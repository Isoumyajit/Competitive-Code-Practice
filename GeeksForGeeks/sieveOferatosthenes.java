import java.util.*;

public class sieveOferatosthenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] primeCheck = new boolean[100000];
        Arrays.fill(primeCheck, true);
        primeCheck[0] = false;
        primeCheck[1] = false;
        for (int i = 2; i * i < 100000; i++) {
            if (primeCheck[i]) {
                for (int j = i * i; j < 100000; j += i) {
                    primeCheck[j] = false;
                }
            }
        }
        for (int i = 2; i < 100000; i++) {
            if (i > n)
                break;
            if (primeCheck[i]) {
                System.out.print(i + " ");
            }
        }
        sc.close();
    }
}
