import java.util.Scanner;

import java.util.*;

public class Revature_code {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        sumModifiedArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        s.close();
    }

    public static void sumModifiedArray(int[] arr) {
        int maxElement = Arrays.stream(arr).max().getAsInt();
        int[] leftHelper = new int[maxElement + 1];
        int[] RightHelper = new int[maxElement + 1];
        int[] mainIndex = new int[maxElement + 1];
        int LeftValIndex = 0;
        int RightValIndex = 0;
        Arrays.fill(leftHelper, 0);
        Arrays.fill(RightHelper, 0);
        Arrays.fill(mainIndex, 0);
        for (int i = 0; i < arr.length; i++) {
            mainIndex[arr[i]] = 1;
        }
        for (int i = 0; i < mainIndex.length; i++) {
            if (mainIndex[i] == 1) {
                leftHelper[i] = LeftValIndex;
                LeftValIndex = i;
            }
        }
        for (int i = mainIndex.length - 1; i >= 0; i--) {
            if (mainIndex[i] == 1) {
                RightHelper[i] = RightValIndex;
                RightValIndex = i;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = leftHelper[arr[i]] + RightHelper[arr[i]];
        }
    }
}
