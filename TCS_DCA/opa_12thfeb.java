
import java.util.*;

public class opa_12thfeb {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Solution array[] = new Solution[4];

        for (int i = 0; i < 4; i++) {
            array[i] = new Solution(s.nextInt(), s.next(), s.next(), s.nextInt(), s.nextBoolean());
        }
        Solution.display(array);
        s.close();
    }
}

class Solution {

    private int regNo;
    private int price;
    private String agencyName;
    private String packageName;
    private boolean flightFacility;

    Solution(int regNo, String agencyName, String packageName, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageName = packageName;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    public static void display(Solution array[]) {
        for (int i = 0; i < 4; i++) {
            System.out.println(array[i].regNo + array[i].agencyName + array[i].packageName + array[i].price
                    + array[i].flightFacility);
        }
    }
}
