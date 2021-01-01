import java.util.*;

public class Find_Nunique_integers_sum_zero {
    
     public static void main(String args[]){
          Scanner s = new Scanner(System.in);
          int n = s.nextInt();
         Solution_Find_range obj = new Solution_Find_range();
         int res[] = obj.sumZero(n);
         for(int i = 0; i<n ; i++)
           System.out.print(res[i] + " ");
         s.close();
     }
}

class Solution_Find_range{
    public int[] sumZero(int n) {
        
        int res[] = new int[n];
        if(n % 2 == 1){
        for(int i=0 , j = -(n/2) ; i<n ; i++){
                   res[i] = j++;
            }
        }
        else{
             for(int i=0 , j = -(n/2) ; i<n ; i++){
                    if(i < n/2)
                       res[i] = j++;
                    else
                        res[i] = ++j;
            }
        }
        return res;
    }
}
