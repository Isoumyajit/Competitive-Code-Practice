import java.util.Random;
import java.util.Scanner;

public class Test {

    public static void main(String[] args)
    {
        int compscore = 0;
        int userscore = 0;
        System.out.println("              Rock-Paper-Scissor Game\n\n");

        for (int i = 1; i <= 10; i++) {

            System.out.println("                      Round " + i + "\n                                      "
                    + "Computer Score" + "       " + "Your Score");
            System.out.println(" 1 for rock \n 2 for paper \n 3 for scissor");
            for (int j = 1; j <= 5; j++) {
                System.out.println("Match No: " + j + "--->");
                Random rand = new Random();
                int compgen = rand.nextInt(4);
                Scanner sc = new Scanner(System.in);
                int userinp = sc.nextInt();

                if (compgen == 1)
                    System.out.println("Computer has chosen rock.");
                else if (compgen == 2)
                    System.out.println("Computer has chosen paper.");
                else if (compgen == 3)
                    System.out.println("Computer has chosen scissor.");

                if (userinp == 1)
                    System.out.println("You have chosen rock.");
                else if (userinp == 2)
                    System.out.println("You have chosen paper.");
                else if (userinp == 3)
                    System.out.println("You have chosen scissor.");
                else
                    System.out.println("Invalid choice");

                if (compgen == userinp)
                    System.out.println("Tie between you and computer                 0                 0");
                else if (compgen == 1 && userinp == 2) {
                    compscore++;
                    System.out.println("Computer won in this match                   1                 0");
                } else if (compgen == 1 && userinp == 3) {
                    compscore++;
                    System.out.println("Computer won in this match                   1                 0");
                } else if (compgen == 2 && userinp == 1) {
                    userscore++;
                    System.out.println("You won in this match                        0                 1");
                } else if (compgen == 2 && userinp == 3) {
                    compscore++;
                    System.out.println("Computer won in this match                   1                 0");
                } else if (compgen == 3 && userinp == 1) {
                    compscore++;
                    System.out.println("Computer won in this match                   1                 0");
                } else if (compgen == 3 && userinp == 2) {
                    userscore++;
                    System.out.println("You won in this match                        0                 1");
                }

            }
            System.out.println("     " + "Total score of computer = " + compscore + "\n      " + "Your total score = "
                    + userscore);

            if (compscore == userscore) {
                System.out.println("  " + "Tie between you and computer in this round.");
            } else if (compscore < userscore) {
                System.out.println("  " + "Well done! You have won in this round.");
            } else {
                System.out.println("  " + "Computer has won in this round. Better Luck next time!");
            }

        }
    }}

    

    

    

    
    
    

    

     

    
    
        
        
    
    
        
        
    
    
        
        
    
    
        
        
    
    
        
        
    
    
        
        
    







