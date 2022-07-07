
// { Driver Code Starts
import java.util.*;

class GFG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.print("()");
            ArrayList<ArrayList<Integer>> res = new solve().AllSubsets(arr, n);
            for (int i = 0; i < res.size(); i++) {
                System.out.print("(");
                for (int j = 0; j < res.get(i).size(); j++) {
                    if (j != res.get(i).size() - 1)
                        System.out.print((res.get(i)).get(j) + " ");
                    else
                        System.out.print((res.get(i)).get(j));
                }
                System.out.print(")");

            }
            System.out.println();
        }
        sc.close();
    }
}// } Driver Code Ends

class solve {
    // Function to find all possible unique subsets.
    public ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {
        // your code here
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> helper = new ArrayList<>();
        Arrays.sort(arr);
        makeSubsets(arr, n, 0, answer, helper);
        return answer;
    }

    public static void makeSubsets(int[] arr, int n, int index, ArrayList<ArrayList<Integer>> answer,
            ArrayList<Integer> helper) {

        if (index == n) {
            return;
        }

        for (int i = index; i < n; i++) {
            if (i == index || arr[i] != arr[i - 1]) {
                helper.add(arr[i]);
                answer.add(new ArrayList<>(helper));
                makeSubsets(arr, n, i + 1, answer, helper);
                helper.remove(helper.size() - 1);
            }
        }

    }
}
