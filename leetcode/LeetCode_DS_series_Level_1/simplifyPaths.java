import java.util.Stack;

public class simplifyPaths {
    public String simplifyPath(String path) {
        StringBuffer answer = new StringBuffer();
        Stack<Character> helper = new Stack<>();
        int len = path.length();
        int count = 0;
        boolean isLevelUp = false;
        boolean isWord = false;
        for (int i = 0; i < len; i++) {

            if (i == 0) {
                helper.push(path.charAt(i));
            } else {
                if (helper.peek() == '/' && path.charAt(i) == '/')
                    continue;
                else if (helper.peek() != '/' && path.charAt(i) == '/') {

                    if (!isWord && count < 3) {
                        if (count == 2)
                            isLevelUp = true;
                        while (!helper.isEmpty() && count > 0) {
                            helper.pop();
                            count--;
                        }
                    }
                    if (isLevelUp) {
                        if (helper.size() > 1 && helper.peek() == '/')
                            helper.pop();
                        while (!helper.isEmpty() && helper.peek() != '/') {
                            helper.pop();
                        }

                    }

                    if (!isLevelUp) {
                        count = 0;
                        if (helper.peek() != '/')
                            helper.push('/');

                    }
                    isWord = false;
                    isLevelUp = false;
                } else if (path.charAt(i) == '.') {
                    helper.push('.');
                    count++;

                } else if (path.charAt(i) != '.' && path.charAt(i) != '/') {
                    helper.push(path.charAt(i));
                    isWord = true;
                    count = 0;
                }
            }
            // System.out.println(helper);
        }

        if (!isWord) {
            if (count < 3) {
                if (count == 2)
                    isLevelUp = true;
                while (!helper.isEmpty() && count > 0) {
                    helper.pop();
                    count--;
                }
            }
            if (isLevelUp) {
                if (helper.size() > 1 && helper.peek() == '/')
                    helper.pop();
                while (!helper.isEmpty() && helper.peek() != '/') {
                    helper.pop();
                }
            }
        }
        if (helper.size() > 1 && helper.peek() == '/')
            helper.pop();
        while (!helper.isEmpty())
            answer.append(helper.pop());

        return answer.reverse().toString();
    }
}