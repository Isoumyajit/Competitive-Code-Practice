import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class groupAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = sc.nextLine();
        }
        System.out.println(SolutionGroupAnagrams.anagram(strs));
        sc.close();
    }
}

class SolutionGroupAnagrams {

    public static List<List<String>> anagram(String[] strs) {

        List<List<String>> answer = new LinkedList<>();

        int len = strs.length;
        if (len == 0) {
            answer.add(new ArrayList<>());
            return answer;
        } else if (len == 1) {

            answer.add(new ArrayList<>());
            answer.get(0).add(strs[0]);
            return answer;
        }

        HashMap<String, List<String>> helper = new HashMap<>();

        for (String dummy : strs) {
            char[] extrastorage = dummy.toCharArray();
            Arrays.sort(extrastorage);
            String sorted = new String(extrastorage);
            if (helper.containsKey(sorted)) {
                helper.get(sorted).add(dummy);
            } else {

                helper.put(sorted, new ArrayList<>());
                helper.get(sorted).add(dummy);
            }
        }
        answer.addAll(helper.values());
        return answer;
    }

}
