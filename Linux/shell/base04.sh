#!/bin/bash

sum=`expr 2 + 2`   # 使用 expr  进行数学计算  2+2 之间要有空格
echo "${sum}" 

a=10
b=20

min=`expr $a - $b`
echo $min


if [ $a == $b ]       #  ==  != 
then 
    echo "a==b"
else
    echo "a!=b"
fi


if [ $a -gt $b ]
then
    echo "aaaa"
fi

file="/var/www/runoob/test.sh"
if [ -r $file ]
then 
    echo "file can write"
else
    echo "file not write"
fi


