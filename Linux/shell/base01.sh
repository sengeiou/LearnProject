#!/bin/bash
echo "Hello, bash"

name="cocoa"
echo $name

# readonly 只读变量
# readonly name
#name="cocoa1"   #会报错，注释了

# 删除变量  不能删除只读变量
unset name
echo $name  # 删除后使用不会报错


age=12


#拼接字符串
result="the name = ${name} and age = ${age}"
echo $result


#字符串长度
str="Jun Jun is my name"
echo ${#str}

# 截取子串
echo ${str:3:6}
# 动态截取子串
echo ${str:3:${#str}}


# Array

arr=(
    1
    2
    3
)

# 使用下标获取数组   @表示所有
echo ${arr[1]}
echo ${arr[@]}

# 获取数组长度  两种写法都可以
echo "len = ${#arr[@]}"
echo "len = ${#arr[*]}"

# 获取数组下标1 元素的长度
echo "len = ${#arr[1]}"


:<<!
1231
123123
123
!






