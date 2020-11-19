

# chgrp [groupName] [fileName]  
//只有超级用户和属于组的文件所有者才能变更文件关联组。非超级用户如需要设置关联组可能需要使用 chgrp 命令。

```
chgrp root testFile.md   
chgrp -R root dirName    // 循环修改

```


# chown [userName] [fileName]    
//chown 需要超级用户 root 的权限才能执行此命令。

```
chown cocoa testFile.md

```
