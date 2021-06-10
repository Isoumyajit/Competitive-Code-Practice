import java.util.*;

public class Main {
    public static void main(String[] args) {
        resturant_bill object = new resturant_bill();
        object.choose_Menu();
        object.OrderMenu();
    }
}

class resturant_bill {

    private HashMap<String, Double> menu = new HashMap<String, Double>();
    HashMap<String, Double> choosen_menu = new HashMap<String, Double>();
    private ArrayList<String> itemList = new ArrayList<String>();
    private ArrayList<Double> priceList = new ArrayList<Double>();
    private ArrayList<Integer> quantity = new ArrayList<Integer>();
    private ArrayList<Double> TotalPrice = new ArrayList<Double>();

    private double TotalSum = 0;

    resturant_bill() {
        menucard();
        split_into_list();
    }

    public void menucard() {
        this.menu.put("Biriyani", 210.00);
        this.menu.put("Mutoon-Kasha", 200.00);
        this.menu.put("Fried-Rice", 190.00);
        this.menu.put("Chilli-chicken", 180.00);
        this.menu.put("Sikh-Kebab-full", 190.00);
        this.menu.put("Sikh-kebab-half", 90.00);
    }

    public void split_into_list() {
        itemList.addAll(menu.keySet());
        priceList.addAll(menu.values());
    }

    public void choose_Menu() {

        Scanner s = new Scanner(System.in);
        System.out.println("\t\t\t\t Please Enter Maximum Number of Items you want to order :: \t\t\t\t");
        int n = s.nextInt();
        System.out.println("Sl No.\t\t\t Item \t\t\t\t Price");
        Iterator menuIterator = menu.entrySet().iterator();
        int j = 1;
        while (menuIterator.hasNext()) {
            Map.Entry<String, Double> element = (Map.Entry) menuIterator.next();
            System.out.println(j + "\t\t\t " + element.getKey() + "\t\t\t" + element.getValue());
            j++;
        }
        for (int i = 1; i <= n; i++) {
            System.out.println("Please Enter yout " + i + " Item :: ");
            int item = s.nextInt();
            switch (item) {
                case 1:
                    choosen_menu.put(itemList.get(0), priceList.get(0));
                    System.out.println("How much quantity you want to order now !!");
                    quantity.add(s.nextInt());
                    break;
                case 2:
                    choosen_menu.put(itemList.get(1), priceList.get(1));
                    System.out.println("How much quantity you want to order now !!");
                    quantity.add(s.nextInt());
                    break;
                case 3:
                    choosen_menu.put(itemList.get(2), priceList.get(2));
                    System.out.println("How much quantity you want to order now !!");
                    quantity.add(s.nextInt());
                    break;
                case 4:
                    choosen_menu.put(itemList.get(3), priceList.get(3));
                    System.out.println("How much quantity you want to order now !!");
                    quantity.add(s.nextInt());
                    break;
                case 5:
                    choosen_menu.put(itemList.get(4), priceList.get(4));
                    System.out.println("How much quantity you want to order now !!");
                    quantity.add(s.nextInt());
                    break;
                default:
                    System.out.println("please Enter valid Item No. ");
            }
        }
        s.close();
    }

    public void OrderMenu() {
        calculate_Total();
        Total_Sum_Up();
        print_bill();

    }

    public void calculate_Total() {
        Iterator menuIterator = choosen_menu.entrySet().iterator();
        int j = 0;
        while (menuIterator.hasNext()) {
            Map.Entry<String, Double> element = (Map.Entry) menuIterator.next();
            TotalPrice.add(element.getValue() * quantity.get(j++));
        }
    }

    public void Total_Sum_Up() {
        for (int i = 0; i < TotalPrice.size(); i++) {
            TotalSum += TotalPrice.get(i);
        }
    }

    public void print_bill() {
        Iterator menuIterator = choosen_menu.entrySet().iterator();
        System.out.println("\t\t\t\t\t\t\t Here comes the bill \t\t\t\t\t");
        System.out.println("\t\t Sl No.\t\t Item \t\t Quantity \t\t\t Price \t\t\t Total Price");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < choosen_menu.size(); i++) {
            Map.Entry<String, Double> element = (Map.Entry) menuIterator.next();

            System.out.println("\t\t " + (i + 1) + " \t\t " + element.getKey() + " \t " + quantity.get(i)
                    + "  \t\tX\t\t " + element.getValue() + "  \t\t    " + TotalPrice.get(i));
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t---------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t Total Sum ::: " + TotalSum);
    }
}
