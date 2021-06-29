
import java.util.*;

public class minimumDistancebetweenNumbers {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        int prev = -1, next = -1, result = Integer.MAX_VALUE;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int x = s.nextInt();
        int y = s.nextInt();
        for (int i = 0, j = n - 1; i < n || j >= 0;) {
            if (j >= 0 && arr[i] == x && arr[j] != y) {
                j--;
                next = j;
            } else if (i < n && arr[j] == y && arr[i] != x) {
                i++;
                prev = i;
            } else if (i < n && j >= 0 && arr[i] == x && arr[j] == y) {
                result = Math.min(result, Math.abs(next - prev));
                i++;
                j--;
            } else if (i < n) {
                i++;
            } else {
                j--;
            }
        }
        s.close();
    }
}
