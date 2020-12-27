n = int(input())
n1 = int(input())
data = []
data1 = []
for i in range(n):
    data.append(int(input()))
for i in range(n1):
    data1.append(int(input()))

suma = 0
sumb = 0

for i in data:
    suma += i
for i in data1:
    sumb += i
data1 = set(data1)
diff = (sumb - suma) // 2

for i in data:
    if i + diff in data1:
       print(i , i + diff)
       break
