#!/bin/bash
# 数组

#定义数组
arr=(
    1
    2
    3
)

test_array[0]=1
test_array[1]=1



echo "数组的元素为: ${test_array[*]}"
echo "数组的元素为: ${arr[@]}"


# 数组长度
echo "数组长度 ${#arr[@]}"



#遍历数组
for item in ${arr[@]} ; do 
    echo $item
done