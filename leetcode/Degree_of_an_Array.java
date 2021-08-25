import java.util.*;

public class Degree_of_an_Array {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        int maxLength = 0, degree = 0;
        for (int i = 0; i < arr.length; i++) {
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
            temp.putIfAbsent(arr[i], i);
            if (hash.get(arr[i]) > degree) {
                degree = hash.get(arr[i]);
                maxLength = i - temp.get(arr[i]) + 1;
            } else if (hash.get(arr[i]) == degree) {
                maxLength = Math.min(maxLength, i - temp.get(arr[i]) + 1);
            }
        }
        System.out.println(maxLength);
        s.close();
    }
}
