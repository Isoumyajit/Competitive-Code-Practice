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

        int n, j, ind;
        int i = 0;
        long long int k ;
        cin >> n >> k;
        long long int height[n] , sum_arr = 0, cur_sum_a = 0, cur_sum_b = 0, diff = 0;
        bool flag = false;
        for (i = 0; i < n; i++)
        {
            cin >> height[i];
        }

        for (i = 0; i < n; i++)
        {
            sum_arr += height[i];
        }

        if (sum_arr < k *2)
        {
            cout << "-1" << endl;
            continue;
        }
        else if (sum_arr == 2 *k)
        {
            cout << n << endl;
            continue;
        }
        else
        {
            sort(height, height + n);

            for (i = n - 1; i > 0; i--)
            {
				
				//cout<<height[i]<<" "<<i<<" ";
                cur_sum_a += height[i];

                if (cur_sum_a >= k)
                {
                    break;
                }

                flag = false;

                for (j = i - 1; j > 0; j--)
                {

                    if (k - cur_sum_a <= height[j])
                    {
                        flag = true;
                        ind = j;
                    }
                    else
                      break;
                }
                if (flag)
                {
                	//cout<<height[i-1] <<" "<<height[ind]<<" inner";
                    swap(height[i-1] , height[ind]);
                    flag = false;
                }
            }
		//	cout<<endl<<i<<endl;
            for (i = i - 1; i > 0; i--)
            {
                flag = false;
                //cout<<height[i]<<" "<<i<<" ";
                cur_sum_b += height[i];

                if (cur_sum_b >= k)
                {
                    break;
                }
                for (j = i - 1; j > 0; j--)
                {

                    if (k - cur_sum_b <= height[j])
                    {
                        flag = true;
                        ind = j;
                    }
                    else
                        break;
                }
                if (flag)
                {
                	 //cout<<height[i-1]<<" "<<height[ind]<<endl;
                     swap(height[i-1] , height[ind]);
                    flag = false;
                }
            }

            cout << n - i << endl;
        }
    }
    return 0;
}
