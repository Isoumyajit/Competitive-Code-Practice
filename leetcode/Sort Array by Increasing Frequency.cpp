class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {
        
         unordered_map<int , int> mp; 
         vector<pair<int , int >> ans;
         vector<int> ans_temp;
         int i , j , k ; 
    
         for(i = 0 ; i < nums.size() ; i++){ 
               if(mp.find(nums[i]) == mp.end())
                     mp.insert(make_pair(nums[i] , 1));
               else
                 mp[nums[i]]++;
          }
         copy(mp.begin() , mp.end() , back_inserter(ans));
        
         sort(ans.begin() , ans.end() , cmp);
        
        for(auto &j : ans){
              int cnt = j.second;
              for(i = 1 ; i<=cnt ; i++)
                   ans_temp.push_back(j.first);
        }
        return ans_temp;
    }
    static bool cmp(pair<int , int > o1 , pair<int , int > o2){
         
          if (o1.second != o2.second )return o1.second < o2.second;
          else
             return  o1.first > o2.first;
    }
};