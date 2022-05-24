import java.util.Stack;

public class minimumremovetomakeValidParentheses {

}

class SolutionminimumRemoveToMakeValidParentheses {
    public static String minimumremovetomakeValidParentheses(String str) {

        String answer = "";
        Stack<Integer> helper = new Stack<>();
        int len = str.length();
        if (len == 0)
            return str;

        for (int index = 0; index < len; index++) {

            if (str.charAt(index) == '(') {
                helper.push(index);
            } else {
                if (!helper.isEmpty() && str.charAt(helper.peek()) == '(') {
                    helper.pop();
                } else {
                    helper.push(index);
                }
            }
        }
        if (helper.isEmpty())
            return str;

        for (int index = 0; index < len; index++) {
            if (helper.contains(index)) {
                answer += str.charAt(index);
            }
        }
        return answer;
    }
}
