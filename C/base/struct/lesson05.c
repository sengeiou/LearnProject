#include <stdio.h>
#include <string.h>
#include <stdlib.h>

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

struct Sds{
    size_t len;
    size_t free;
    char content[];
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

    // 函数中传递结构体，尽量使用指针


    // struct Human *human = (struct Human*) malloc(sizeof(struct Human));

    // memcpy(human-> name , dest , len);

    // printf("the name of human %s\n", human-> name);

    // free(human);
    // human = NULL;

    struct Sds* sds = (struct Sds*)  malloc(sizeof(struct Sds));
    sds -> len = 10;

    char* str = "123123";
    size_t length = strlen(str);
    sds -> free = sds->len - length;
    memcpy(sds->content, str, length);    


    return 0;
}

