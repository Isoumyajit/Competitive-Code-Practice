import java.util.Arrays;
import java.util.Comparator;

public class queueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {

        int len = people.length;
        int count = 0, i = 0, in = 0;
        int[][] answer = new int[len][2];
        for (int index = 0; index < len; index++) {
            answer[index][0] = -1;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int a[], int b[]) {
                if (a[0] < b[0])
                    return -1;
                else if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else
                    return 1;
            }
        });

        for (int index = 0; index < len; index++) {
            count = people[index][1];
            if (count == 0) {
                for (i = 0; i < len; i++) {
                    if (answer[i][0] == -1) {
                        answer[i][0] = people[index][0];
                        answer[i][1] = people[index][1];
                        break;
                    }
                }
            } else {
                for (i = 0; i < len && count > 0; i++) {
                    if (answer[i][0] == -1 || answer[i][0] >= people[index][0]) {
                        count--;
                    }
                }
                in = i == len ? i - 1 : i;
                for (i = in; i < len; i++) {
                    if (answer[i][0] == -1) {
                        answer[i][0] = people[index][0];
                        answer[i][1] = people[index][1];
                        break;
                    }
                }
            }
        }
        return answer;
    }
}