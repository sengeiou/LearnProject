#include <stdio.h>

//作用域整个项目，若要在其他文件中使用，需要申明 extern
int a = 100;



int main(){
    //局部变量
    int  a = 10;

    //同名的变量，数据会采用就近原则，优先使用局部变量 这里的a = 10
    printf("%d\n",a);   
    

}