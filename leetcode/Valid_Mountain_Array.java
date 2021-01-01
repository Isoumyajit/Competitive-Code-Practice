/*

leetcode ==> https://leetcode.com/problems/valid-mountain-array/

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104
*/

import java.util.Scanner;

public class Valid_Mountain_Array {
    
   public static void main(String[] args){ 
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
     int arr[] = new int[n];
     for(int i = 0; i<n ; i++)
        arr[i] =s.nextInt();
    SolutionMountain obj = new SolutionMountain();
    System.out.println(obj.validMountainArray(arr));
    s.close();
   }
}
class SolutionMountain{
    public boolean validMountainArray(int[] arr) {
     
        int i = 0 , j = arr.length - 1;
        for(i= 0 ; i < j ; ){
             
               if(arr[i] < arr[i+1])
                   i++;
               else if(arr[j] < arr[j-1])
                   j--;
               else if(arr[j] >= arr[j - 1])
                   return false;
               else
                   return false;
        }
        if(i == j && i!= 0 && j != arr.length - 1)
            return true;
        else
            return false;
}
}
