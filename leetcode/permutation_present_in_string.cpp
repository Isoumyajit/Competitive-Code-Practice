/* palindrome present is permutataion or not */
#include<bits/stdc++.h>
using namespace std;

bool isPal(vector<int> v);
int main()
{
	 int i,j,n,x;
	 cin>>n; 
	 bool flag;
	 vector<int> v;
	 for(i=0 ; i<n ; i++)
	    {
	    	 cin>>x;
	    	 v.push_back(x);
		}
	 //left rotation 
	 for(i= 0 ; i<n ; i++)
	     {
	     	 for(j=0 ; j<n-1 ; j++)
	     	    {
	     	    	 swap(v[j],v[j+1]);
	     	    	 flag = isPal(v);
	     	    	 if(flag)
	     	    	    break;
	     	    	cout<<endl;
				 }
				 if(flag)
				    break;
		 }
		if(flag)
		    cout<<"yes this can be a palindrome"<<endl;
		else 
		  for(i= 0 ; i<n ; i++)
	     {
	     	 for(j=0 ; j<n-1 ; j++)
	     	    {
	     	    	 swap(v[j],v[j+1]);
	     	    	 flag = isPal(v);
	     	    	 if(flag)
	     	    	    break;
	     	    	cout<<endl;
				 }
				 if(flag)
				    break;
		 }
}
bool isPal(vector<int> v)
 {
 	 int i,j;
 	 for(i=0 , j = v.size()-1; i<j ; i++,j--)
 	  {
 	  	   if(v[i] != v[j])
 	  	       return false;
	   }
	return true;
 }
 
