/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/

#include<bits/stdc++.h>
using namespace std;

    int main(){
	
		int mid , i , j , n , x , target;
		cin>>n;
		cin>>target;
        vector<int> res;
        vector<int> nums;
        for(i = 0 ;i<n ; i++)
        {
        	cin>>x;
        	nums.push_back(x);
		}
        i = 0 ;
        j = nums.size() - 1;
        bool flagi = false;
        bool flagj = false;
        if(i == j && target == nums[0])
        {
            res.push_back(0);
            res.push_back(0);
            for(i = 0 ; i<res.size() ; i++)
         			cout<<res[i]<<" ";
         	return 0;
            
        }
        while(i < j)
        {
            if(nums[i] == target && !flagi)
            {
                 flagi = true;
                res.push_back(i);
                 if(flagj)
                 {
                     reverse(res.begin() , res.end());
                     break;
                 }
            }
            if(nums[j] == target && !flagj)
            {
                flagj = true;
                res.push_back(j);
                if(flagi)
                    break;
            }
             if (nums[j] > target)
            {
                 j = j - 1;
            }
            else 
                i = i + 1;
        }
        
        if(res.size() == 0)
        {
            res.push_back(-1);
            res.push_back(-1);
                 
        }
        else if(i == j)
        {
            res.push_back(i);
        }
        for(i = 0 ; i<res.size() ; i++)
         cout<<res[i]<<" ";
        
    }
