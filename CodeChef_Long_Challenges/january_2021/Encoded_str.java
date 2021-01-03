
import java.io.BufferedReader;
import java.io.*;

public class Encoded_str {
    
    public static void main (String[] args) throws IOException
	{
		// your code goes here
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(bf.readLine());
		
		while(test-->0){
		    
			String n = bf.readLine();
			
		    String data = bf.readLine();
		    int i , k = 0;
		    int j = 97;
		    
		    char hash[] = new char[26];
		    for(i = 0 ; i<26 ; i++){
		        hash[i] = (char)j++;
		    }
		    
		    for(i = 0 , j = 0; i<data.length() ; i++){
		        k++;
		        if(k == 4){
		            char ch = hash[Integer.parseInt(data.substring(j , k+j),2)];
					System.out.print(ch);
					k = 0;
					j = i + 1;
		        }
			}
		}
		bf.close();
	}
}
