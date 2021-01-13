/* if we can delete any digit to make a check of palindrome */

#include<bits/stdc++.h>
#include<string.h>
using namespace std;

bool recursion(vector<char>&, int , int);
bool ispalindrome(vector<char>);

int main()
 { 
     string str;
     int i ,j, k , n =0;
     cout<<"enter"<<endl;
     getline(cin , str);
     vector<char> v;
    for(i=0 ; i<str.length() ; i++)
        v.push_back(str.at(i));
     if(!recursion(v , 0 , v.size()))
	     cout<<"Not possible1";
 }
 bool recursion(vector<char> &vec,int key , int n)
  {
  	    int i ;
  	    int flag = ispalindrome(vec);
  	    if(vec.size() == 1)
  	        return false;
  	    if(flag)
  	       {
  	       	   if(key == 0)
  	       	      {
				  cout<<"The string is palindrome itself nothing should be deleted";
  	       	      return true;
  	       	      }
  	       	  else
  	       	      {
  	       	      	 cout<<"The string can be made palindrome by deleting "<<key - 48<<endl;
  	       	      	 return true;
					   }
			 }
		    
		for(auto it = vec.begin() ; it != vec.end() ; it++)
		  {
		  	     char swap = *it;
		  	     vec.erase(it);
		  	     bool f = recursion(vec , swap , n);
		  	     vec.insert(it,swap);
		  	      if(f)
		  	        return true;
		  	     if(vec.size() < n )
		  	        return false;
		  }
  }
  
  bool ispalindrome(vector<char> vec)
   {
   	  int i;
   	  int j = vec.size();
   	  for(i = 0 , j = vec.size()-1 ; i<j ; i++ , j--)
   	   {
   	   	      if(vec[i] != vec[j])
   	   	         {
					   return false;
				}
		  }
	 return true;
   }
