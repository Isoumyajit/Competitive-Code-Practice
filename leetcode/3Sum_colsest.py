# # Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
# # Return the sum of the three integers.
# # You may assume that each input would have exactly one solution.
# Example 1:
#
# Input: nums = [-1,2,1,-4], target = 1
# Output: 2
# Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

n = int(input())
target = int(input())
data = []
for i in range(n):
    data.append(int(input()))
res = 0
dif = 9999
data.sort()
if len(data) == 3:
    print(sum(data))
for i in range(n):
    j = i + 1
    k = len(data) - 1
    while j < k :
        sum = data[i] + data[j] + data[k]
        if abs(sum - target) < dif:
            dif = abs(sum - target)
            res = sum
        elif abs(sum - target) == target:
            res = target
            break
        if sum < target:
            j += 1
        elif sum > target:
            k -= 1
    if res == target:
        break
print(res)