import java.util.*;

public class Final_Prices_with_spcl_dis {
    
     public static void main(String args[]){
         Scanner s = new Scanner(System.in);
         int n = s.nextInt();
         int arr[] = new int[n];
         for(int i = 0 ;i<n ; i++)
            arr[i] = s.nextInt();
         s.close();

         Final_Prices_with_spcl_dis_sol obj = new Final_Prices_with_spcl_dis_sol();
         int res[] = obj.finalPrices(arr);

         for(int i = 0 ; i<res.length ; i++){
             System.out.println(res[i] +" ");
             
         }
     }
}

class Final_Prices_with_spcl_dis_sol{
    public int[] finalPrices(int[] prices) {
        
         int i , len = prices.length, val;
         Stack<Integer> st = new Stack<Integer>();
        
        for(i = len - 1 ; i>= 0 ; i--)
        {
           if(i == len - 1){
               st.push(prices[i]);
           }
           else{
              
                while(!st.isEmpty() && prices[i] < st.peek()){
                    st.pop();
                }
            if(!st.isEmpty()){
                val = st.peek();
                st.push(prices[i]);
                prices[i] -= val;
            }
           else
             st.push(prices[i]);
          }
        }
        return prices;
         
    }
}
