import java.util.*;

public class MajorityElement {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        s.close();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int element = 0;
        for (Map.Entry<Integer, Integer> A : map.entrySet()) {
            if (A.getValue() > n / 2) {
                element = A.getKey();
                break;
            }
        }
        System.out.println(MooreVoting(arr));
    }

    //// Using Optimized Approach Moore Voting Algorithm
    public static int MooreVoting(int arr[]) {
        int count = 1;
        int majority_elelment = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (majority_elelment != arr[i]) {
                count--;
                if (count == 0) {
                    majority_elelment = arr[i];
                    count = 1;
                } else {
                    count++;
                }
            }
        }

        return majority_elelment;
    }
}
