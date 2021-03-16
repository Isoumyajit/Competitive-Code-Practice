import java.util.*;

public class FirstSmallestDistance {

    public static void main(String args[]) {

        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        if (n < 2) {
            System.out.println("Invalid Input");
            return;
        }
        first = Arrays.stream(arr).min().getAsInt();
        for (int i = 0; i < n; i++) {

            if (second > arr[i] && first != arr[i]) {
                second = arr[i];
            }
        }

        if (second == Integer.MAX_VALUE) {
            System.out.println("Equal");
        } else {
            System.out.println(first + " " + second);
        }
    }
}
