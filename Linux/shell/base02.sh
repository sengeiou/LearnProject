#!/bin/bash
# 传递参数


echo "Shell 传递参数实例！";
echo "执行的文件名：$0";   # 执行的文件名：./base02.sh
echo "第一个参数为：$1";   
echo "第二个参数为：$2";
echo "第三个参数为：$3";


echo "参数个数 $#"
echo "所有参数 $*"


echo "-- \$* 演示 ---"
for i in "$*"; do
    echo $i
done



echo "-- \$@ 演示 ---"
for i in "$@"; do
    echo $i
done