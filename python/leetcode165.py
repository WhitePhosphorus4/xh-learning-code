version1 = '1.0.1'
version2 = '1'
temp1 = version1.split('.')
temp2 = version2.split('.')
len1 = len(temp1)
len2 = len(temp2)
# print(version1)
# print(len(temp))
if len1 > len2:
    maxsize = len1-1
else:
    maxsize = len2-1
flag = 0
x = range (0,5)
for i in range(0,maxsize):
    if i>=len1:
        a1 = 0
    else:
        a1 = int(temp1[i])
    if i>=len2:
        a2 = 0
    else:
        a2 = int(temp2[i])
    if a1 > a2:
        print(1)
        break
    elif a1 < a2:
        print(-1)
        break
    else:
        continue
print(flag)