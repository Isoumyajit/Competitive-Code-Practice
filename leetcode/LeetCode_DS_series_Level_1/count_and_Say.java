public class count_and_Say {
    public String countAndSay(int n) {
        return makeString(n);
    }

    public static String makeString(int n) {

        if (n == 1) {
            return "1";
        } else if (n == 2) {
            return "11";
        } else if (n == 3)
            return "21";
        else if (n == 4)
            return "1211";

        else {
            String res = makeString(n - 1);
            StringBuffer temp = new StringBuffer();
            int len = res.length();
            int[] hash = new int[10];
            for (int index = 0; index < len; index++) {
                if (index == 0 || res.charAt(index) == res.charAt(index - 1)) {
                    hash[res.charAt(index) - '0']++;
                } else {
                    temp.append(String.valueOf(hash[res.charAt(index - 1) - '0']));
                    temp.append(String.valueOf(res.charAt(index - 1) - '0'));
                    hash[res.charAt(index - 1) - '0'] = 0;
                    hash[res.charAt(index) - '0']++;
                }
            }
            temp.append(String.valueOf(hash[res.charAt(len - 1) - '0']));
            temp.append(String.valueOf(res.charAt(len - 1) - '0'));
            return temp.toString();
        }

    }
}