import java.util.*;

public class Minimum_Absolute_Difference {
    
    public static void main(String args[])
    {
         Scanner s = new Scanner(System.in);
         int n = s.nextInt();
         int arr[] = new int[n];
         for(int i = 0 ; i<n ; i++)
         {
             arr[i] = s.nextInt();
         }
         Solution_Minimum_Absolute_Diff obj = new Solution_Minimum_Absolute_Diff();
         System.out.println(obj.minimumAbsDifference(arr));
         s.close();


    }
}
class Solution_Minimum_Absolute_Diff{
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        int i = 0, len = arr.length;
        Boolean flag = false;
        int min = Integer.MAX_VALUE;
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        Integer temp[] = new Integer[2];
        Arrays.sort(arr);
        
        for(i = 1 ; i<len ; i++)
        {
             min =  Math.min(min , arr[i] - arr[i-1]);
        }
        
        for(i = 1 ; i<len ; i++)
        {
            flag = false;
             if(arr[i] - arr[i-1] == min)
             {
                 temp[0] = arr[i-1];
                 temp[1] = arr[i];
                 flag = true;
             }
            if(flag)
                 ls.add(Arrays.asList(temp.clone()));
        }
        return ls;
    }
}
