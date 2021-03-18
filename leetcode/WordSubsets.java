import java.util.*;

public class WordSubsets {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String A[] = new String[n];
        String B[] = new String[2];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextLine();
        }
        System.out.println("enter");
        for (int i = 0; i < 2; i++) {
            B[i] = sc.nextLine();
        }
        sc.close();

        // ......
        List<String> result = new ArrayList<String>();
        int hash[] = new int[26];
        for (String str : A) {
            int count = 0;
            boolean flag = false;
            Arrays.fill(hash, 0);

            for (int i = 0; i < str.length(); i++) {
                hash[str.charAt(i) - 97]++;
            }
            for (int i = 0; i < B.length; i++) {
                flag = false;
                int hash1[] = hash.clone();
                for (char a : B[i].toCharArray()) {
                    if (hash1[a - 97] >= 1) {
                        hash1[a - 97]--;
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                    if (flag)
                        count++;
                    if (flag == false)
                        break;
                }
            }
            if (count == B.length) {
                result.add(str);
            }
        }
        System.out.println(result);
    }
}
