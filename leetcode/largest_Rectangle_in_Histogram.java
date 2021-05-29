import java.util.*;

public class largest_Rectangle_in_Histogram {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int area = Solution_largest_rectange.largestRectangleArea(arr);
        System.out.println(area);
        s.close();
    }
}

class Solution_largest_rectange {
    public static int largestRectangleArea(int[] heights) {
        int area = 0;
        int max_area = Integer.MIN_VALUE;

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        Stack<Integer> helper = new Stack<Integer>();
        for (int i = 0; i < heights.length; i++) {

            if (helper.empty()) {
                left[i] = -1;
                helper.add(i);
            } else {

                while (!helper.isEmpty() && heights[helper.peek()] >= heights[i]) {
                    helper.pop();
                }
                if (helper.isEmpty()) {
                    left[i] = -1;
                } else {
                    left[i] = helper.peek();
                }
                helper.add(i);
            }
        }
        helper.clear();
        for (int i = heights.length - 1; i >= 0; i--) {

            if (helper.empty()) {
                right[i] = heights.length;
                helper.add(i);
            } else {

                while (!helper.isEmpty() && heights[helper.peek()] >= heights[i]) {
                    helper.pop();
                }
                if (helper.isEmpty()) {
                    right[i] = heights.length;
                } else {
                    right[i] = helper.peek();
                }
                helper.add(i);
            }
        }
        for (int i = 0; i < left.length; i++) {
            System.out.print(left[i] + " ");
        }
        for (int i = 0; i < right.length; i++) {
            System.out.print(right[i] + " ");
        }
        for (int i = 0; i < heights.length; i++) {
            area = (right[i] - (left[i] + 1)) * heights[i];
            max_area = Math.max(area, max_area);
        }
        return max_area;
    }
}
