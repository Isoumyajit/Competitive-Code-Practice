
def Solution(date1 , date2):
    date1 = date1.split('/')
    date2 = date2.split('/')
    day1 = int(date1[0])
    mon1 = int(date1[1])
    y1 = int(date1[2])

    day2 = int(date2[0])
    mon2 = int(date2[1])
    y2 = int(date2[2])
    if day2 < day1:
        if mon2 == 3:
            if (y2 % 4 == 0 and y2 % 100 != 0) or y2 % 400 == 0:
                day2 += 29
            else:
                day2 += 28
        elif mon2 == 5 or mon2 == 7 or mon2 == 10 or mon2 == 12:
            day2 += 30
        else:
            day2 += 31
        mon2 -= 1
    if mon2 < mon1:
        mon2 += 12
        y2 -= 1
    resulty = str(abs(y2 - y1))
    resultmon = str(mon2 - mon1)
    resultd = str(day2 - day1)

    ans = ""
    ans = resultd + '/' + resultmon + '/' + resulty
    return ans

date1 = input()
date2 = input()
print(Solution(date1 ,date2))