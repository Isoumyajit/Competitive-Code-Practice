
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class wordPattern {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String pattern = bf.readLine();
        String s = bf.readLine();
        System.out.println(SolutionwordPattern.wordPattern(pattern, s));
        bf.close();
    }
}

class SolutionwordPattern {
    public static boolean wordPattern(String pattern, String s) {

        boolean result = false;
        String[] helper = s.split(" ");

        if (helper.length != pattern.length())
            return result;

        if (helper.length == 1)
            return !result;

        HashMap<Character, String> mapping_string = new HashMap<>();
        int index = 0;

        for (char dummy : pattern.toCharArray()) {
            if (mapping_string.containsKey(dummy)) {

                if (mapping_string.get(dummy).equals(helper[index++]))
                    continue;
                else
                    return result;
            } else {
                if (mapping_string.containsValue(helper[index]))
                    return result;
                mapping_string.put(dummy, helper[index++]);
            }

        }

        return !result;
    }
}