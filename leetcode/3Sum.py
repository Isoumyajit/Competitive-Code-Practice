n = int(input())
lst = []
for i in range(n):
    lst.append(int(input()))
temp = []
lst.sort()
k = 0
j = 0
for i in range(len(lst)):
    j = i + 1
    k = len(lst) - 1
    while j < k:
        if lst[i] + lst[j] + lst[k] == 0:
            if [lst[i] , lst[j] , lst[k]] not in temp:
                temp.append([lst[i] , lst[j] , lst[k]])
            j += 1
            k -= 1
            print(temp)
        elif lst[i] + lst[j] + lst[k] > 0:
            k -= 1
        elif lst[i] + lst[j] + lst[k] < 0:
            j += 1

print(temp)
