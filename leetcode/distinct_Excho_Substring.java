import java.util.*;

public class distinct_Excho_Substring {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(distinctEchoSubstrings(str));
        s.close();
    }

    public static int distinctEchoSubstrings(String text) {

        int answer = 0;
        String helper = "";
        ArrayList<String> temp = new ArrayList<String>();

        for (int i = 0; i < text.length(); i++) {

            helper += text.charAt(i);
            for (int j = helper.length(), k = j - 1; k >= 0; k--) {
                String t = helper.substring(k, j);
                if (t.length() * 2 > text.length())
                    break;
                // System.out.println(helper);
                if (!temp.contains(t)) {
                    temp.add(t);
                }
            }

        }
        // System.out.println(temp);
        for (int i = 0; i < temp.size(); i++) {
            String t = temp.get(i);
            t += t;
            if (text.contains(t)) {
                answer++;
            }

        }
        return answer;
    }
}
