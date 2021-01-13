/* palindrome present is permutataion or not */

#include<bits/stdc++.h>
using namespace std;

bool permutation(char[] , int , int );
bool isPal(char[] , int );
int main()
 {
 	 int i , j, n , k;
 	 cin>>n;
 	 char a[n];
 	 cin>>a;
 	 bool f = permutation(a , 0 , n-1);
 	 if(f)
 	    cout<<"Yes this can be made palindrome "<<endl;
 	 else 
 	    cout<<"No"<<endl;
 	 return 0;
 }
 
 bool permutation(char a[] , int l , int n)
  {
  	 if(l == n )
  	    {
  	    	 bool flag = isPal(a , n);
  	    	 if(flag)
  	    	    {
  	    	    	 return true;
				  }
			return false;
		  }
	int i ;
	bool f;
	for(i= l ; i<n ; i++)
	  {
	  	 swap(a[i],a[l]);
	  	 f = permutation(a , l+1 , n );
	  	 swap(a[i] , a[l]);
	  	if(f)
	  	  return true;
	  }
  }
  
  bool isPal(char a[] , int l)
 {
 	 int i,j;
 	 for(i=0 , j = l ; i<j ; i++,j--)
 	  {
 	  	   if(a[i] != a[j])
 	  	       return false;
	   }
	return true;
 }
 
