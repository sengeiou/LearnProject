#include <stdio.h>

int main(){
    int a = 10;
    int* p1 = &a;
    void* p2 = p1;


    // void 类型
    printf("%p\n",p1);
    printf("%p\n",p2);
    //0x7fffd3ac1524
    //0x7fffd3ac1524

    printf("%d\n",*((int*)p2));

    // 查看void 的大小，8，就是int 的大小
    printf("%ld\n",sizeof(p2));

    // void bbb ;
    


}