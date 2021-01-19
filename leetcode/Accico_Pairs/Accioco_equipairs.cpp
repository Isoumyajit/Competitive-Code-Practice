#include<bits/stdc++.h>
using namespace std;

int main()
 {
 	 int i, start , end ,n , j;
 	 cin>>n;
 	 int arr[n];
 	 for(i=0 ; i<n ; i++)
 	   cin>>arr[i];
 	
 	int sum1 = 0 , sum2 = 0 , sum3 = -1;
 	for(i= 0 , j = n-1 ; i<j ;)
 	 {
 	 	 if(sum1 < sum3 )
 	 	  {
 	 	  	
 	 	  	  sum1 += arr[i];
 	 	  	    i += 1;
 	 	  	  
			}
		 else if(sum1 > sum3 )
		  {
		  	 if(j == n-1)
		  	    {
		  	    	sum3 = 0;
				  }
		  	 sum3 += arr[j];
		  	 j -= 1;
		  	 
		  }
		  else {
		  	 start = i+1 ;
		  	 end = j-1;
		  	 break;
		  }
	  }
	for(i = start ; i<=end ; i++)
	 {
	 	  sum2 += arr[i];
	 }
	 if(sum2 == sum1 && sum3 == sum2)
	  {
	  	 printf("Accico Equi pairs are in range :{ %d , %d } \n" ,start-1, end+1 );
	  	 printf("Pair1 = { %d , %d} \n\n" , 0 , start-2);
	  	 printf("pair2 = {%d  , %d } \n\n" , start , end );
	  	 printf("Pair3 = { %d , %d } \n\n" , end+2 , n-1);
	  }
	  else{
	  	 printf("Pair don't exist in the list \n\n");
	  }
 	
 }
