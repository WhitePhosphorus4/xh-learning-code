def dec2bin(num):
    two = 0
    j = 0
    two = ''
    while num != 0:
        i = num % 2
        num = num//2
        two = str(i) + two
        j=j+1
    return two
    
print(dec2bin(10086))