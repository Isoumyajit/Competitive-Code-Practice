import java.util.*;

class Solution_Array_parity {

    public int[] sortArrayByParityII(int[] A) {

        int i = 0, j = A.length - 1;

        while (i < A.length - 1 && j >= 0) {
            if (A[j] % 2 == 1)
                j -= 2;
            else if (A[i] % 2 == 0)
                i += 2;

            else {
                swap(A, i, j);
            }
        }

        return A;
    }

    public static void swap(int A[], int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}

class Sort_Array_By_Parity {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        Solution_Array_parity obj = new Solution_Array_parity();
        int[] ans = obj.sortArrayByParityII(arr);
        for (int an : ans)
            System.out.print(an + " ");
        s.close();
    }
}