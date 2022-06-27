public class partition_into_minimum_number_ofDecinumbers {
    public int minPartitions(String n) {

        int len = n.length();
        if (len == 0)
            return 0;
        else if (len == 1) {
            if (Integer.valueOf(n) > 0 && Integer.valueOf(n) <= 9)
                return n.charAt(0) - '0';
            else if (n.charAt(0) == '0')
                return 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, n.charAt(i) - '0');
        }

        return max;
    }
}