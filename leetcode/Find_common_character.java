
import java.util.*;

public class Find_common_character {
    
     public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String A[] = new String[n];

        for(int i = 0 ; i<n ; i++){
            A[i] = s.nextLine();
        }
        Solution_Find_common obj = new Solution_Find_common();
        List<String> ls = obj.commonChars(A);

        for(int i= 0 ; i<ls.size() ; i++){
            System.out.println(ls.get(i));
        }
        s.close();
     }
}

class Solution_Find_common{
    public List<String> commonChars(String[] A) {
        
        int hash[] = new int[26];
        int temp[] = new int[26];

        Arrays.fill(hash , 0);
        temp = hash.clone();
        
        List<String> ans = new ArrayList<String>();
        
        int i , j ;
        for(i = 0 ; i<A[0].length() ; i++){
            
             hash[A[0].charAt(i) - 97]++;
        }
        
        for(i = 1 ; i<A.length ; i++){
            
            Arrays.fill(temp , 0);
            for(j = 0 ; j < A[i].length() ; j++){
                 
                  temp[A[i].charAt(j) - 97]++;
            }
            
            for(j = 0; j<26 ; j++){
                
                if(temp[j] < hash[j]){
                    hash[j] = temp[j];
                }
                
            }
        }
        
        for(i = 0 ; i<26 ; i++){
            
             for(j = 0 ; j<hash[i] ; j++){
                 
                  ans.add(Character.toString((char)(i + 97)));
             }
        }
    return ans;
    }
}
