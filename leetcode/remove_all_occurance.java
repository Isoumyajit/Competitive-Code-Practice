import java.util.*;

public class remove_all_occurance {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String find = sc.nextLine();
        sc.close();

        str = str.replaceAll(find, "");
        System.out.println(str);

    }
}
