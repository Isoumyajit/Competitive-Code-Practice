import java.util.Arrays;

public class maximumAreaInaCake {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        int len1 = horizontalCuts.length;
        int len2 = verticalCuts.length;
        long m = 1000000007;

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;

        for (int index = len1; index > 0; index--) {
            if (index == len1) {
                max1 = Math.max(max1, (h - horizontalCuts[index - 1]));
            } else
                max1 = Math.max(max1, (horizontalCuts[index] - horizontalCuts[index - 1]));
        }
        for (int index = len2; index > 0; index--) {
            if (index == len2) {
                max2 = Math.max(max2, (w - verticalCuts[index - 1]));
            } else
                max2 = Math.max(max2, (verticalCuts[index] - verticalCuts[index - 1]));
        }
        max2 = Math.max(max2, (verticalCuts[0] - 0));
        max1 = Math.max(max1, (horizontalCuts[0] - 0));

        return (int) (max1 % m * max2 % m);
    }
}