n = int(input())
lst = []
cnt = 0
temp = ""
for i in range(n):
    lst.append(int(input()))
for i in lst:
    temp = str(i)
    if len(temp)%2 == 0:
        cnt += 1
print(cnt)