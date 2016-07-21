# git 初始化
***


 * git --version 查看git的版本
 * git config --global user.name "xxx"
 * git config --global user.email "xxx@xx.com"

 * git init  创建版本库（需要在文件夹下创建，或者直接在 git init 后跟上路径）
 * git add [file_name]
 * git commit -m "commit message"  （commit 也可以缩写成ci）
> 这里来解释下  add和commit



 * git grep "xxx"   搜索工作区的内容 ，很牛逼

 //取消设置
  *  git config --unset --global user.name
  *  git config --unset --global user.email

//查看设置

 *  git config user.name
 *  git config user.email
