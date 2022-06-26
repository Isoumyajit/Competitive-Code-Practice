import java.util.Scanner;

public class numberOfCardsweCanObtain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int index = 0; index < n; index++)
            arr[index] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(SolutionSlidingWindow.maxScore(arr, k));
        sc.close();
    }

}

// Recursive naive approach

class SolutionRecursive {
    public int maxScore(int[] cardPoints, int k) {

        return calculateMax(cardPoints, 0, cardPoints.length, k);

    }

    public static int calculateMax(int[] arr, int start, int end, int k) {
        if (k == 0) {
            return 0;
        }
        return Math.max(arr[end - 1] + calculateMax(arr, start, end - 1, k - 1),
                arr[start] + calculateMax(arr, start + 1, end, k - 1));
    }
}

class SolutionSlidingWindow {
    public static int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int totalSum = 0;
        int left = 0;
        for (int val : cardPoints)
            totalSum += val;
        for (int index = 0; index < len - k; index++) {
            left += cardPoints[index];
        }

        int answer = left;
        for (int index = 0; index < k; index++) {
            left -= cardPoints[index];
            left += cardPoints[len - k + index];
            answer = Math.min(answer, left);
        }
        return totalSum - answer;
    }
}