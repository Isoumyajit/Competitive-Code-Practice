import java.util.*;

class singleNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] usergiven = new int[n];
        for (int i = 0; i < n; i++) {
            usergiven[i] = sc.nextInt();
        }

        System.out.println(SolutionSingleNumber1.singleNumber(usergiven));
        sc.close();
    }
}

// Solution 1

class SolutionSingleNumber1 {
    public static int singleNumber(int[] nums) {

        int number = -1;
        HashMap<Integer, Integer> helper = new HashMap<Integer, Integer>();
        for (int i : nums) {

            helper.put(i, helper.getOrDefault(i, 0) + 1);
        }
        for (int key : helper.keySet()) {
            if (helper.get(key) == 1) {
                number = key;
                break;
            }
        }
        return number;

    }
}

// Solution 2

class SolutionSingleNumber2 {
    public static int singleNumber(int[] nums) {

        int number = -99999;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] != nums[i - 1]) {
                number = nums[i - 1];
                break;
            }
        }
        return number;

    }
}