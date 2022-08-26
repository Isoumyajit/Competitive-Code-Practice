public class reOrderedPowerOfTwo {
    public boolean reorderedPowerOf2(int n) {

        if (n == 1)
            return true;
        int power = 1;
        int lenN = (int) Math.log10(n) + 1;
        for (int start = 1; start < 32; start++) {
            power = power * 2;
            int lenPower = (int) Math.log10(power);
            if (lenPower + 1 < lenN)
                continue;
            else if (lenPower + 1 == lenN) {
                if (isValid(power, n))
                    return true;
            } else if (lenPower + 1 > lenN)
                break;
        }
        return false;

    }

    private static boolean isValid(int number, int n) {
        int[] hash = new int[10];
        while (n > 0) {
            hash[n % 10]++;
            n /= 10;
        }
        while (number > 0) {
            hash[number % 10]--;
            if (hash[number % 10] < 0)
                return false;
            number /= 10;
        }
        return true;
    }
}
