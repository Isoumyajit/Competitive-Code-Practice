#include <iostream>
#include<bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
	long long int t ;
	cin>>t;
	while(t--){
	     
	        long long int m , n , v = 0;
	        cin>>n>>m;
	        long long int arr[n] , arr1[m] , min_ele;
	        long long int i = 0 , j = 0 ; 
	        for(i = 0 ; i<n ; i++){
	             cin>>arr[i];
	        }
	        
	        for(i = 0 ; i<m ; i++){
	            cin>>arr1[i];
	        }
	        
	        vector<long long int> ans;
	        i = 0;
	        j = 0;
	        
	        sort(arr , arr+n);
	        sort(arr1 , arr1+m);
	        ans.push_back(0);
	        
	       while( i < n && j < m ){
	             
	            min_ele = max( (v | arr[i]) , (v & arr1[j]) );
	             if(min_ele == (v | arr[i])){
	                 v = min_ele;
	                 if(find(ans.begin() , ans.end() , v) == ans.end())
	                    ans.push_back(v);
	                 i++;
	             }
	            else if(min_ele == (v & arr1[j])){
	                 v = min_ele;
	                 if(find(ans.begin() , ans.end() , v) == ans.end())
	                    ans.push_back(v);
	                 j++;
	            }
	       }
	    cout<<v<<endl;
	    
	     while( i < n ){
	         if(find(ans.begin() , ans.end() , v | arr[i]) == ans.end())
	           {
	                	ans.push_back(v | arr[i]);
	                	v = v | arr[i];
	                }
	         i++;
	     }
	     while(j < m ){ 
	         if(find(ans.begin() , ans.end() , v & arr1[j]) == ans.end())
	                {
	                	ans.push_back(v & arr1[j]);
	                	v = v & arr1[j];
	                }
	         j++;
	     }
	     
	     for(auto k : ans)cout<<k<<" ";
	     
	     cout<<ans.size()<<endl;
	       
	}
	return 0;
}
