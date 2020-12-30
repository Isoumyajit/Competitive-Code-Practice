import java.util.*;

public class Find_Lucky_Number {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
       Solution2 obj = new Solution2();
       int n = s.nextInt();
       int matrix[][] = new int[n][n];

       for(int i = 0; i<n ; i++)
         for(int j = 0 ; j <n ; j++)
             matrix[i][j] = s.nextInt();
       System.out.println(obj.luckyNumbers(matrix)); 
       s.close();
    }
   

}
class Solution2 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        List<Integer> ls = new ArrayList<Integer>();
        int k = 0 , min_ele = Integer.MAX_VALUE , max_ele = Integer.MIN_VALUE;
        for(int i = 0 ; i<matrix[0].length ; i++)
        {
            k = 0;
            max_ele = matrix[k][i];
            for(k = 0 ; k<matrix.length ; k++)
            {
                if(matrix[k][i] > max_ele)
                {
                    max_ele = matrix[k][i];
                }
            }
            
            ls.add(max_ele);
        }
        
        k = 0;
        for(int i = 0 ; i<matrix.length ; i++)
        {
            k = 0;
            min_ele = matrix[i][k];
            for(k = 1 ; k<matrix[i].length ; k++)
            {
                if(min_ele > matrix[i][k])
                    min_ele = matrix[i][k];
            }
            if(ls.contains(min_ele))
                return Arrays.asList(min_ele);
        }
        
        ls.clear();
        return ls;
    }
}