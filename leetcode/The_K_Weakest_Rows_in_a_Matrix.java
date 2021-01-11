import java.util.*;

public class The_K_Weakest_Rows_in_a_Matrix {
    
    public static void main(String args[])
    { 
            Scanner s = new Scanner(System.in);
            s.close();
    }
}

class The_K_Weakest_Rows_in_a_Matrix_solution{
    public int[] kWeakestRows(int[][] mat, int k) {
        
         int i , j ;
         int cnt = 0;
         int ans[] = new int[k];
         HashMap<Integer , Integer > temp = new LinkedHashMap<Integer, Integer>();

         for(i = 0 ; i<mat.length ; i++)
         {
             cnt = 0;
               for(j = 0 ; j<mat[i].length ; j++)
               { 
                 if(mat[i][j] == 1)
                     cnt++;
                 else
                    break;
               }
              temp.put(i , cnt);
         }

       temp = sortByValue(temp);
       i = 0;
       for(Map.Entry<Integer , Integer> f: temp.entrySet())
       {
           ans[i++] = f.getKey();
           if( i == k)
               break;
       }
        return ans;
    }
    
        public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)       
        { 
        // Create a list from elements of HashMap 
        List<Map.Entry<Integer, Integer> > list = 
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    }
}