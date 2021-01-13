import java.util.*;

public class Flipping_An_Image {
    
    public static void main(String... args){
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int A[][] = new int[n][n];

    for(int i= 0 ; i < n ; i++){
        for(int j = 0 ; j< n ; j++){
            A[i][j] = s.nextInt();
        }
      }
      Solution_Flipping obj = new Solution_Flipping();
      A = obj.flipAndInvertImage(A);
      for(int i =0 ; i<A.length ; i++){
          for(int j = 0 ; j <A[i].length ; j++){
              System.out.print(A[i][j]);
          }
          System.out.println();
      }
      s.close();
   }
}

class Solution_Flipping{
    public int[][] flipAndInvertImage(int[][] A) {
        int i , j , k;
        if(A.length == 1){
            if(A[0][0] == 1){
                A[0][0] = 0; 
                return A;
            }
            else{
                A[0][0] = 1;
                return A;
            }
                    
        }
        for(i = 0 ; i < A.length ; i++){
         
              for(j = 0 , k = A[i].length - 1 ; j < k ; j++ , k--){
                  
                   A[i][j] = A[i][j] ^ A[i][k];
                   A[i][k] = A[i][j] ^ A[i][k];
                   A[i][j] = A[i][j] ^ A[i][k];
                  
                  if(A[i][j] == 0 )A[i][j] = 1;
                  else if(A[i][j] == 1)A[i][j] = 0;
                  if(A[i][k] == 0 )A[i][k] = 1;
                  else if(A[i][k] == 1)A[i][k] = 0;
              }
            
            if(j == k ){
                 if(A[i][j] == 0 )A[i][j] = 1;
                 else if(A[i][j] == 1)A[i][j] = 0;
            }
            
        }

        // for(i = 0 ; i < A.length ; i++){
        //     for(j = 0 ;  j<A[i].length ; j++){
        //         if(A[i][j] == 0 ){
        //             A[i][j] = 1;
        //         }
        //         else{
        //             A[i][j] = 0;
        //         }
        //     }
        // }
        return A;
    }
}
