#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "ex16.h"
//#include "string.h"
#include "advanced/string01.h"
#include "const01/const01.h"
#include "memory/memory.h"
#include "variable/test1.h"
#include "pretreatment/pretreatment.h"
#include "jiqiao/jiqiao.h"
#define VALUE 10

#define MAX(a, b) ((a > b) ? (a) : (b))

extern int  global_b;


int sum(int *start, int *end) {
    int total = 0;
    while (start < end) {
        total += *start;
        start++;
    }
    return total;
}

int getArraySize(int arr[]) {
    printf("the size of arr %d \n", sizeof arr);
}

int calcLen(char *c) {
    char *p = c;
    while (*c != '\0') {  // 注意是单引号，已经犯过错
        c++;
    }
    return c - p;
}


struct Action{
    int id;
    int position;
};


//
//int main() {
////    printf("Hello, World!\n");
////    printf("this is ten %d \n", VALUE);
////
////    int a = MAX(10,20);
////    printf("this is max method %d \n",a);
////
////    int array[7] = {1,2,3,4,5,6,7};
////
////    printf("%p \n", array);
////    int *p = &array;
////    for (int i = 0 ; i < 7 ; i++) {
////        printf("%p \n", p + i);
////        printf("%d \n", *(p+i));
////    }
////
////    printf("the a size of %zd \n", sizeof a);
////    getArraySize(array);
////
////    int total = sum(p, p+7);
////    printf("the sum is %d \n", total );
////
////    printf("the size of  pointer %lu \n", sizeof(char*));
//
////    test();
////    string_main();
//
////    string01_main();
//
//
////    char *c = "Hello,world";
////    int result = calcLen(c);
////    printf("the len is %d \n", result);
////
////
////    test1_main();
////    printf("the global_b used at main.c  global_b = %d \n",global_b);
////
////
////    memory_main();
////
////    pre_main();
//
////    jiqiao_main();
//
//
//    int num = 2;
//    struct Action *actions = (struct Action*) malloc(sizeof(struct Action) * num);
//
//
//    struct Action a1={2,2500};
//    struct Action a2={1,2500};
//
//    actions= &a1;
//    actions++;
//
//    actions=&a2;
//    actions--;
//
//
//
//    for (uint8_t i = 0; i < 2; i++) { //循环填充舵机ID和对应目标位置
//        printf("the p address  = %d \n", actions->id);
//        printf("the p address  = %d \n", actions->position);
//
//        actions++;
//    }
//
//
//
//
//    return EXIT_SUCCESS;
//}
//
//
//
//
typedef struct Sds SDS;

struct Sds{
    int len;
    int free;
    char str[];
};


SDS* init(char* str, size_t len){
    SDS* s = (SDS*) malloc(sizeof(int) *2 + sizeof(char)* (len+1));
    s->len  = len;
    s->free = 0;
    memcpy(s->str, str, len+1);
    return s;
}

void printSds(SDS *p){
    if(p==NULL){
        return;
    }
    printf("the len of sds = %d , and the free = %d, the content = %s \n", p->len, p-> free, p->str);
}

void freeSds(SDS *p){
    if(p==NULL){
        return;
    }
    free(p);
    p=NULL;
}

SDS* append(SDS* p, char* str, size_t len){
    size_t cutLen = p-> len;
    if(len <= cutLen){
        memcpy(p-> str, str,len+1);
        return p;
    }else{
        freeSds(p);
        return  init(str,len);
    }
}


int main(){
    char *str = "Helloworld!!!";
    size_t len  = strlen(str);
    SDS* sds = init(str, len);
    printSds(sds);

    char *str2 = "User Defaults won't write to disk right away";
    SDS* s2 = append(sds, str2, strlen(str2));
    printSds(s2);

    freeSds(sds);
    freeSds(s2);

}