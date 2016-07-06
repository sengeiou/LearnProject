#include <stdio.h>

//变量可以相互赋值，
// 指针也可以，类型要相同
int main(){

        int  i = 10;
        int j = 20;
        int *p  = &i;

        printf("%p\n", p);
        printf("%d\n", *p);
        p = &j;

        printf("%p\n", p);
        printf("%d\n",  *p);
        //打印结果不同，说明修改成功

        return 0;
}
