import java.util.*;

public class Decomprase_run_length {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
    
    int i ;
    int arr[] = new int[sc.nextInt()];
    for(i = 0 ; i < arr.length ; i ++)
        {
             arr[i] = sc.nextInt();
        }
    sc.close();
    Solution_run_length obj = new Solution_run_length();
    int ans[] = obj.decompressRLElist(arr);
    for(i = 0 ; i < ans.length ; i++){
         System.out.print(ans[i] + " ");
    }
 
    }
}
class Solution_run_length{
    public int[] decompressRLElist(int[] nums) {
        
        int i , k , cnt = 0; 
        List<Integer> ans = new ArrayList<Integer>();
        
        for(i = 0 ; i < nums.length - 1; i+=2){
              for(k = 1 ; k <= nums[i] ; k++){
                   ans.add(nums[i+1]);
              }
        }
        int temp[] = new int[ans.size()];
        for( int j : ans){
             temp[cnt++] = j;
        }
        return temp;
    }
}