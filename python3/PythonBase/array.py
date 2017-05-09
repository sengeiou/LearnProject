# array is mutable 

x = [1, 2, 3, 4]

# index
print(x[0])
# print(x[2])  IndexError: list index out of range

# len
print("x.len is " + str(len(x)))

# min max
print("x.min is " + str(min(x)))
print("x.max is " + str(max(x)))


# func list
array = list('Hello')
print(array)

# base list operation

# change list

x[1] = 10
print(x)  # [1, 10, 3, 4]
del x[3]
print(x)  # [1, 10, 3]


# func of array

# append
x.append(5)
x.append(6)

print(x)  # [1, 10, 3, 5, 6]

# count  统计某个元素出现的次数
print(x.count(1))  # 1


# index
print(x.index(1))  # 0


# insert
x.insert(2, 111)
print(x)   #[1, 10, 111, 3, 5, 6]

#pop 
x.pop()
print(x)   #[1, 10, 111, 3, 5]

#remove
x.remove(111)
print(x)   #[1, 10, 3, 5]

#reverse
x.reverse()
print(x)   #[5, 3, 10, 1]

#sort
x.sort()
print(x)  # [1, 3, 5, 10]



#tuple  is unmutable （不可变）
#create tuple 
t =()   #empty tuple 
tt = (1,2,3,4,5)
ttt = tuple(x)  #create tuple from array

print(t)
print(tt)
print(ttt)

# t[0]= 11  'tuple' object does not support item assignment

