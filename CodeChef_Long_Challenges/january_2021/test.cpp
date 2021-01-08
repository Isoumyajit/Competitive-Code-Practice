#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main()
{
   	// your code goes here
    int test;
    cin >> test;

    while (test--)
    {
        long long int k , i , n , x;
        cin >> n >> k;
        long long int sum_arr = 0 , ans = 0, sum1 = 0, sum2 = 0;
        bool flag = false;
        vector<long long int> height;
        vector<long long int > ans;
        for (i = 0; i < n; i++)
        {
            cin >> x;
            height.push_back(x);
            sum_arr += x;
        }

        if (sum_arr < k*2 || n == 1)
        {
            cout << "-1" << endl;
        }
        else if (sum_arr == 2*k)
        {
            cout << n << endl;
        }
        else
        {
        sort(height.begin() , height.end());
        sum1 = height[n-1];
        sum2 = height[n-2];
        height.pop_back();
        height.pop_back();
        ans = 2;
            
        while(1)
            {  
   
                if((sum1 >= k && sum2 >= k) || height.size() == 0) break;
                if(sum1 < k)
                {
                    long long int i = 0, flag = 0;
                    for(i=0; i<height.size(); i++)
                    {
                        if(height[i]+sum1 >= k) 
                        {
                            flag = 1;
                            break;
                        }
                    }
                    if(flag==1) 
                    {
                        ans++;
                        a.push_back(height[i]);
                        sum1 += height[i];
                        height.erase(height.begin() + i);
                    }
                    else
                    {
                        ans++;
                        a.push_back(height.back());
                        sum1 += height.back();
                        height.pop_back();
                    }
                } 
                if(height.size() == 0)break;
                if(sum2 < k)
                {
                    long long int i = 0, flag = 0;
                    for(i=0; i<height.size() ; i++)
                    {
                        if(height[i]+sum2 >= k) 
                        {
                            flag = 1;
                            break;
                        }
                    }
                    if(flag==1) 
                    {
                        ans++;
                        sum2 += height[i];
                         a.push_back(height[i]);
                        height.erase(height.begin() + i);
                    }
                    else
                    {
                        ans++;
                         a.push_back(height.back());
                        sum2 += height.back();
                        height.pop_back();
                    }
                }
            }

            if(sum1 >= k && sum2 >= k) {
                cout<<ans<<endl;
                cout<<a.size()<<" ";
            }
            else cout<<-1<<endl;
            }
    }
    return 0;
}
