/* A string is anagram or not */
#include<bits/stdc++.h>
using namespace std;

int main()
 {
 	 int i , j , k , n;
 	 bool flag = true;
     string a; 
     string b;
    getline(cin, a);
 	getline(cin,b);
 	unordered_map<char , int > mp;
 	n = a.length();
 	int m = b.length();
 	if(n == m){
 	 for(i= 0 ; i<n ; i++)
 	     mp[a.at(i)]++;
 	 for(i=0 ; i<n ; i++)
 	   {
 	   	   if(mp.find(b.at(i)) == mp.end() || mp[b.at(i)] == 0)
 	   	       {
 	   	       	   flag = false;
 	   	       	   break;
 	   	       }
 	   	    else 
 	   	       { 
 	   	           mp[b.at(i)]--;
			   }
		}
	 if(flag)
	    cout<<"Yes it is anagram"<<endl;
	else 
	   cout<<"No a anagaram"<<endl;
 }
else
   {
   	  cout<<"Not anagram"<<endl;
   }
}
