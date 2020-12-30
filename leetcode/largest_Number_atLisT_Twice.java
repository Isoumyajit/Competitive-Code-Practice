import java.util.*;

public class largest_Number_atLisT_Twice {
    
    public static void main(String args[]) {
    Solution1 ob = new Solution1();
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] arr = new int[n];
    for(int i=0 ; i<n ; i++)
         arr[i] = s.nextInt();
    System.out.println(ob.dominantIndex(arr));
    s.close();
    }
    

}
class Solution1 {
    public int dominantIndex(int[] nums) {
        
        int i , max_norm = nums[0] , max = nums[0], len = nums.length; 
        if(len == 1)
            return 0;
        for(i = 1 ; i<len ; i++)
        {
             if(nums[i] > max_norm)
             {
                 max = max_norm;
                 max_norm = nums[i];
             }
             else if( (max < nums[i]  && max_norm > nums[i]) || (max == max_norm  && max_norm > nums[i]))
                 max = nums[i];
        }
    
           if(max_norm  >= max * 2)
           {
              for(i = 0 ; i<len ; i++)
             {
                  if(max_norm == nums[i])
                      return i;
             } 
           }
          
              return -1;
    }
}