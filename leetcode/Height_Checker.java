import java.util.*;

public class Height_Checker {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i, cnt = 0;
        int heights[] = new int[n];
        for (i = 0; i < n; i++)
            heights[i] = s.nextInt();
        s.close();
        int temp[] = new int[heights.length];
        temp = heights;

        Arrays.sort(temp);

        for (i = 0; i < heights.length; i++) {
            if (heights[i] != temp[i])
                cnt++;

        }
        System.out.println(cnt);
    }
}
