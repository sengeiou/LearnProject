#include <stdio.h>


// 主函数参数
// argc 表示参数的个数
// argv 表示参数的指针数组
int main(int argc ,char* argv[]){
    

    for(int i = 0 ; i < argc; i++){
        printf("%s\n", *(argv+i));
    }    
    
    return 0;
}
