git 命令


## git log   //查看git提交的历史记录    
## git log -p -2   //查看最近两次提交的不同
## git status      //查看文件状态
## git diff      //对比具体的文件的不同  工作目录(Working tree)和暂存区域快照(index)之间的差异  （可以这么理解，git pull 下来的可以查看，自己修改了文件，但是没有add，也可以用diff查看）






## git branch   //查看所有分支
## git branch {branchName}   //创建分支branchName
## git checkout {branchName}  //切换到分支branchName
## git checkout -b {branchName}  //创建并且切换到分支branchName
## git branch -d {branchName}  //删除分支branchName
## git branch -v  //查看所有分支最后的提交记录


//在master分支下，合并test分支到master
## git merge  test




// git merge conflict   git合并冲突的问题
## git mergetool



// git tag


## git tag  //list all tag
## git tag -l 'v1.0.*'      // list match 'v1.0.*' tags
## git tag -a v1.0 -m  "tag 1.0 "  // create tag (annotated  be command)    simple like:   git tag -a v1.4 -m 'my version 1.4'
## git show v1.0   //show tag info
## git push origin v1.0   //push tag
## git push origin --tags  //push some tag
