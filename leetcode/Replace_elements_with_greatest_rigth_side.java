import java.util.*;

public class Replace_elements_with_greatest_rigth_side {
    
    public static void main(String args[])
     {
          Scanner s = new Scanner(System.in);
          int n = s.nextInt();
          int arr[] = new int[n];

          for(int i = 0 ; i<n ; i++)
                arr[i] = s.nextInt();
          s.close();
          Solution_Replace obj = new Solution_Replace();
          int res[] = obj.replaceElements(arr);
          for(int i = 0 ; i<res.length ; i++)
             System.out.print(res[i] + " ");
            
          
     }
}

class Solution_Replace{
    public int[] replaceElements(int[] arr) {
        
        int i , len = arr.length ,val , max = Integer.MIN_VALUE;

        for(i = len - 1 ; i>=0 ; i--){
             
               if(i == len - 1){
                   max = arr[i];
                   arr[i] = -1;
               }
             else{
                if(arr[i] > max){
                    val = max;
                    max = Math.max(arr[i] , max);
                    arr[i] = val;
                }
                else
                    arr[i] = max;
             }
        }
        return arr;
         
    }
}
