#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        
         int i , j , mid;
         i = 0;
         int len = nums.size();
         j = len - 1;
         
        while(i < j )
        {
            mid = i + (j - i)/2 ;
             if(nums[i] == target)
                 return i;
             else if(nums[j] == target)
                 return j;
            else if(nums[mid] == target)
                return mid;
            else if(nums[mid] > nums[i] && nums[mid] > nums[j])
                i = mid;
            else
                j = mid;
        }
        int a = binarySearch(nums , target , 0 , i - 1);
        int b = binarySearch(nums , target , i  , len - 1);
        return max(a , b);
    }
    
    int binarySearch(vector<int> a , int target , int start , int end)
    {
         int i , j, mid;
         i = start ;
        j = end;
        while(i <= j)
        {
             mid = i + (j - i)/2 ; 
             if(a[mid] == target)
                 return mid;
             else if(a[mid] > target)
                  j = mid - 1;
            else 
                i = mid + 1;
        }
        return -1;
    }
};

int main()
{ 
    Solution obj;
    int target , n , x;
    
    vector<int> nums;
    for(int i = 0 ; i<n ; i++)
       {
       	cin>>x;
       	nums.push_back(x);
	   }
	 cin>>target;
    cout<<obj.search(nums , target);
}
