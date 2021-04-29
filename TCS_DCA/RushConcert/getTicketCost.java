package RushConcert;

import java.util.*;

public class getTicketCost {

    public static double getTicketCosteach() {

        Scanner sc = new Scanner(System.in);
        int i = 0;
        double ticketCost;
        do {
            if (i > 0) {
                System.out.println("Please Enter valid Ticket Cost : ");
            }
            i++;
            System.out.println("Please Enter Ticket Cost ::");
            ticketCost = sc.nextDouble();
        } while (ticketCost < 0);

        sc.close();
        return ticketCost;
    }
}
