
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class permutations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len];
        for (int index = 0; index < len; index++) {
            array[index] = sc.nextInt();
        }
        System.out.println(permutationsSolution.permute(array));
        sc.close();
    }
}

class permutationsSolution {
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> answer = new LinkedList<>();
        int len = nums.length;
        if (len == 0)
            return answer;
        return permutation(nums, 0, len - 1, answer);

    }

    public static List<List<Integer>> permutation(int[] nums, int start, int end, List<List<Integer>> answer) {

        if (start == end) {
            answer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return answer;
        }
        for (int index = start; index <= end; index++) {
            swap(nums, index, start);
            permutation(nums, start + 1, end, answer);
            swap(nums, index, start);
        }
        return answer;
    }

    public static void swap(int[] nums, int a, int b) {
        if (a == b)
            return;
        nums[a] += nums[b];
        nums[b] = nums[a] - nums[b];
        nums[a] = nums[a] - nums[b];
    }
}
