import java.util.Scanner;

public class pow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        int power = sc.nextInt();
        System.out.println(SolutionPow.myPow(number, power));
        sc.close();
    }
}

class SolutionPow {
    public static double myPow(double x, int n) {

        if (n == 0)
            return (double) 1.0;

        double answer = 1.0;
        long power = n;
        if (power < 0)
            power = -1 * power;
        while (power > 0) {
            if (power % 2 == 1) {
                answer = answer * x;
                power--;
            } else {
                x = x * x;
                power /= 2;
            }
        }
        if (n < 0)
            return (double) (1.0) / (double) (answer);
        return answer;
    }
}