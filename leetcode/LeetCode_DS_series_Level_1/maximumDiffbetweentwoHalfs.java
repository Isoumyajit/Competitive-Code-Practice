import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    long colosseum(int N, int A[]) {
        // code here

        int len = A.length;
        long answer = Long.MIN_VALUE;
        long number_check = 0;
        PriorityQueue<Long> helper = new PriorityQueue<>();
        long[] leftSum = new long[len + 5];
        long[] rightSum = new long[len + 5];

        // for(int index = 0; index < len ; index++){
        // max = Math.max(max , A[index]);
        // }
        // int[] hash = new int[max + 1];

        int mid = len / 3;
        for (int index = 1; index <= len; index++) {

            if (index <= mid) {
                leftSum[index] = A[index - 1] + leftSum[index - 1];
                helper.add(Long.valueOf(A[index - 1]));
            } else {
                leftSum[index] = leftSum[index - 1];
                number_check = helper.peek();

                if (A[index - 1] > number_check) {
                    helper.poll();
                    leftSum[index] -= number_check;
                    leftSum[index] += A[index - 1];
                    helper.add(Long.valueOf(A[index - 1]));
                }
            }
        }
        PriorityQueue<Long> helper2 = new PriorityQueue<>(Collections.reverseOrder());

        for (int index = len; index >= 1; index--) {
            if (index >= len - mid + 1) {
                rightSum[index] = A[index - 1] + rightSum[index + 1];
                helper2.add(Long.valueOf(A[index - 1]));
            } else {
                rightSum[index] = rightSum[index + 1];
                number_check = helper2.peek();
                if (number_check > A[index - 1]) {
                    helper2.poll();
                    helper2.add(Long.valueOf(A[index - 1]));
                    rightSum[index] += A[index - 1];
                    rightSum[index] -= number_check;
                }
            }
        }

        for (int index = mid; index <= len - mid; index++) {
            answer = Math.max(answer, leftSum[index] - rightSum[index + 1]);
        }

        return answer;
    }
}