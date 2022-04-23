import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class repeatedDNAsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(SolutionrepititiveDNA.repeatedDNA(str));
        sc.close();
    }
}

class SolutionrepititiveDNA {
    public static List<String> repeatedDNA(String str) {

        int len = str.length();
        List<String> helper = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len - 9; i++) {
            String sub = str.substring(i, i + 10);
            if (map.containsKey(sub)) {
                map.put(sub, map.get(sub) + 1);
            } else {
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        for (Map.Entry<String, Integer> dummy : map.entrySet()) {
            if (dummy.getValue() > 1)
                helper.add(dummy.getKey());
        }
        return helper;
    }
}