import java.util.*;

class Spiral_Matrix {
    
    public static void main(String args[])
    {
        int i , j;
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int arr[][] = new int[m][n];
        for(i = 0 ; i<arr.length ; i++)
            for(j = 0 ; j<arr[i].length ; j++)
                arr[i][j] = s.nextInt();
        
        int k = 0 ;
        int l = 0;
        while( k < n && l < m)
        {
            for(i = l ; i < n ; i++)
                System.out.print(arr[l][i] + " ");
            l++;
            
            for(i = l ;  i < m ; i++)
                System.out.print(arr[i][n-1] + " ");
            n--;
            
            if(l < m){
                for(i = n - 1 ; i>= k ; i--)
                    System.out.print(arr[m-1][i] + " ");
                m--;
            }
            
            if(k < n){
                for(i = m - 1 ; i >= l ; i--)
                    System.out.print(arr[i][k] + " ");
                k++;
            }
        }
        s.close();
    }
   
}
