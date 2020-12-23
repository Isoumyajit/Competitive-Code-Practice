# Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
#
# Note: For the purpose of this problem, we define empty string as valid palindrome.
#
# Example 1:
#
# Input: "A man, a plan, a canal: Panama"
# Output: true
# Example 2:
#
# Input: "race a car"
# Output: false
#
#
# Constraints:
#
# s consists only of printable ASCII characters.

data = input()
str = ""

for i in data:
    if i.isalpha():
        str += i.lower()
i = 0
j = len(str) - 1
while(i < j):
    if str[i] == str[j]:
        i += 1
        j -= 1
    else:
        print("false")
        break
print("true")