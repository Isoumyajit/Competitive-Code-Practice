import java.util.*;

public class No_Of_Ways_VlowelsTogether {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        str = str.toLowerCase();
        int vowel = 0, consonant = 0;
        Set<Character> temp = new HashSet<Character>();
        int hash[] = new int[26];
        Arrays.fill(hash, 0);
        for (int i = 0; i < str.length(); i++) {
            if (!temp.contains(str.charAt(i))) {
                temp.add(str.charAt(i));
                hash[str.charAt(i) - 97]++;
            } else {
                hash[str.charAt(i) - 97]++;
            }
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
                vowel++;
            } else
                consonant++;
        }
        long factor = 1;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 1) {
                factor *= factorial(hash[i]);
            }
        }
        System.out.println((factorial(vowel) * factorial(consonant + 1)) / factor);
    }

    public static int factorial(int x) {
        int fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }
}
