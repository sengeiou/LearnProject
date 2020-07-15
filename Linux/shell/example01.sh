#!/bin/bash
# 打包上传服务器的例子

pwd

echo 'compass dist'
tar -czvf dist.tar.gz ./
sshpass -p "kaifa" scp dist.tar.gz kaifa@192.168.2.126:/tmp
echo 'upload success!!'


sshpass -p "kaifa" ssh  kaifa@192.168.2.126 << EOF
cd /data/html/sale/weex-b/view/fb/
ls
EOF
echo "finished"


#tar -zxvf dist.tar.gz

