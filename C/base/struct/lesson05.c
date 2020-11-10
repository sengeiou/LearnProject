#include <stdio.h>

// 结构体自引用
struct Vedio{
   int age;
//    struct Vedio v;    //会报错, 无法确定v 的大小
    struct Vedio* v;    // 使用指针可以确定长度


};


int main(){

    
    return 0;
}

