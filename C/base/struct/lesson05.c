#include <stdio.h>
#include <string.h>
// 结构体自引用
struct Vedio{
   int age;
//    struct Vedio v;    //会报错, 无法确定v 的大小
    struct Vedio* v;    // 使用指针可以确定长度
};


struct Person {
    int age;
    char name[10];
};

int main(){


    struct Person p = {12,"123"};
    struct Person *p1 = &p;
    int *a = &p1-> age;  // 箭头符号的优先级   

    *a = 11000;

    
    char *dest  = "thisisnameAndroidFlutterIOS";
    size_t len =  strlen(dest);
    memcpy(p1->name,dest,len);


    printf("print name of person %d\n", p1->age);
    printf("print name of person %s\n", p1->name);



    return 0;
}

