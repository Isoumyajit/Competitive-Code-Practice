/* find the highest occuring digit in the array */

#include<bits/stdc++.h>
using namespace std;
void break_digit(int, unordered_map<int,int>&);

bool compare( pair<int , int>& a , pair<int , int > &b)
{
	if(a.second == b.second) 
	   return a.first > b.first;
	
	return a.second > b.second;
}

int main()
 {
 	 int i,j,k,n;
 	 cin>>n;
 	 int arr[n];
 	 for(i=0 ; i<n; i++)
 	    {
 	    	 cin>>arr[i];
	    }
	unordered_map<int , int> mp;
	for(i=0 ;i<n ; i++)
	   {
	   	  break_digit(arr[i] , mp);
	   }
	vector<pair<int , int>> v;
	copy(mp.begin() , mp.end() , back_inserter(v));
	sort(v.begin() , v.end() , compare);
	
	cout<<v[0].first<<endl;
 }
 
 void break_digit(int a , unordered_map<int , int>&mp){
 	  
 	   while(a != 0)
 	     {
 	     	 mp[a%10]++;
 	     	 a /= 10;
		  }
	return ;
 }
