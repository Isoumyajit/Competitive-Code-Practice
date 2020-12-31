import java.util.*;

public class Sum_Of_Even_After_query {
    public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int arr[] = new int[n];
    for(int i = 0 ; i<n; i++)
        arr[i] = s.nextInt();
    int queries[][] = new int[n][2];
    for(int i = 0 ;i<n ; i++)
      {
          queries[i][0] =s.nextInt();
          queries[i][1] = s.nextInt();
      }
    Solution_sum_of_even obj = new Solution_sum_of_even();
    int answer[] = obj.sumEvenAfterQueries(arr, queries);

    for(int i = 0 ; i<answer.length ; i++)
      System.out.println(answer[i] +" ");
    s.close();
    
    }
    
}
class Solution_sum_of_even{
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        
        int ans[] = new int[A.length];
        int k = 0 , sum = 0;
        Set<Integer> temp = new HashSet<Integer>();
        for(int j = 0 ; j<A.length ; j++)
            {
                 if(Math.abs(A[j]) % 2 == 0)
                 {
                     temp.add(j);
                     sum += A[j];
                 }
            }
        
        for(int i = 0 ; i<queries.length ; i++)
        {
            
        if( (Math.abs(queries[i][0]) % 2 == 1 && Math.abs(A[queries[i][1]]) % 2 == 1 ) || ( Math.abs(A[queries[i][1]]) % 2 == 0 && Math.abs(queries[i][0] ) % 2 == 0 ) ){
            
                if(temp.contains(queries[i][1])){
                sum -= A[queries[i][1]];
                }
                else
                    temp.add(queries[i][1]);
            
            A[queries[i][1]] += queries[i][0];
            sum += A[queries[i][1]];
            }
            else
            {
                if(temp.contains(queries[i][1]))
                   {
                       sum -= A[queries[i][1]];
                       temp.remove(queries[i][1]);
                   }
                A[queries[i][1]] += queries[i][0];
            }
            ans[k++] = sum;
        }
        return ans;
    }
}
