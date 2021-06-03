import java.util.*;

public class reverse_whole_string {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        ArrayList<String> helper = new ArrayList<String>();
        StringTokenizer trimmer = new StringTokenizer(str, " ");
        while (trimmer.hasMoreTokens()) {
            helper.add(trimmer.nextToken());
        }
        Collections.reverse(helper);
        StringBuffer res = new StringBuffer();
        int size = helper.size();
        for (String temp : helper) {
            res.append(temp);
            if (size > 0) {
                res.append(" ");
                size--;
            }
        }
        System.out.println(res);
        s.close();
    }
}
