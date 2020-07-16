#!/bin/bash
# 打包上传服务器的例子

# pwd

# echo 'compass dist'
# tar -czvf dist.tar.gz ./
# sshpass -p "kaifa" scp dist.tar.gz kaifa@192.168.2.126:/data/html/sale/weex-b/view/fb/
# echo 'upload success!!'


# sshpass -p "kaifa" ssh  kaifa@192.168.2.126 << EOF
# cd /data/html/sale/weex-b/view/fb/
# ls
# EOF
# echo "finished"

patchDir=fb
patchDesc=用户反馈功能

# minghua=18757187349
# feifan=18757187349

patchMobile[0]=187571873123
patchMobile[1]=18757187349        


mobileList=[
if [ ${#patchMobile[@]} -gt 0 ]
then
    for item in ${patchMobile[@]}; do
        mobileList=$mobileList\"$item\"\,
    done
    # 删除最后的,
    mobileList=${mobileList%?}
fi
mobileList=$mobileList]

# echo $mobileList

curl --location --request POST 'https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=68f78cf6-fc43-464e-a79c-60ddc4e44021' \
--header 'Content-Type: application/json' \
--data-raw '{
        "msgtype": "text",
        "text": {
            "mentioned_mobile_list":'"$mobileList"',
            "content": "weex打包成功，版本描述[  '"$patchDesc"'   ],  版本地址[  '"$patchDir"'   ],  提交记录[ '"${SCM_CHANGELOG}"' ]  "
        }
   }'



# echo ${patchMobile[@]}







# #!/bin/bash
# # 测试环境 weex 上传脚本

# # 修改weex 的路径 和版本描述
# patchDir=fb
# patchDesc=用户反馈功能


# weexRoot=/data/html/sale/weex-b/view
# # readonly weexRoot
# echo 'start compress dist files!!!'
# cd ./dist/view
# tar zcvf dist.tar.gz --exclude=view/*/components --exclude=view/*/component --exclude=*.web.* ./*


# echo 'start upload dist files!!!'
# sshpass -p "kaifa" scp  dist.tar.gz kaifa@192.168.2.126:${weexRoot}


# echo 'upload files success!!!'
# sshpass -p "kaifa" ssh  kaifa@192.168.2.126 << EOF
# cd ${weexRoot}
# mkdir ${patchDir} 
# mv dist.tar.gz ${weexRoot}/${patchDir}
# cd ${patchDir}
# tar -zxvf dist.tar.gz
# EOF
# echo "uncompress success!!!"


# #notice com-wechar              "mentioned_list":["@all"],
# curl --location --request POST 'https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=68f78cf6-fc43-464e-a79c-60ddc4e44021' \
# --header 'Content-Type: application/json' \
# --data-raw '{
#         "msgtype": "text",
#         "text": {
#             "content": "weex打包成功，版本描述[  '"$patchDesc"'   ],  版本地址[  '"$patchDir"'   ],  提交记录[ '"${SCM_CHANGELOG}"' ]  "
#         }
#    }'


