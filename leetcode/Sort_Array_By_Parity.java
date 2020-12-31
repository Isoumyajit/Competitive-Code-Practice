import java.util.*;

class Solution {
    public int[] sortArrayByParityII(int[] A) {
          
        int i = 0, j = A.length - 1;
        
        while(i < A.length - 1 && j >= 0)
        {
            if(A[j] % 2 == 1)
                j -= 2; 
            else if(A[i] % 2 == 0)
                i += 2;
           
            else{
                swap(A , i , j);
            }
        }
        
        return A;
    }
    
    public static void swap(int A[] , int a , int b )
    {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
        return;
    }
}

class Sort_Array_By_Parity{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i<n ; i++)
           arr[i] = s.nextInt();
        Solution obj = new Solution();
        int ans[] = obj.sortArrayByParityII(arr);
        for(int i = 0 ; i<ans.length ; i++)
           System.out.print(ans[i] +" ");
        s.close();
    }
}