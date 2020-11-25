#include <stdio.h>


int main(){

    char *p = "Helloworld";
    //puts()函数只显示字符串， 而且自动在显示的字符串末尾加上换行符。 
    puts(p);


    const char m1[3] = "He";  // m1 和 m2 是一样的，但是 "" 申明更简洁
    const char m2[3] = {'c','2','\0'};  // 如果没有\0, m2 就是一个字符数组，加了\0 就是字符串


    // 通常让编译器自动计算长度
    const char m3[] = "Helloworld!";

    const char *p3 =  "Helloworld!";

    // p3 和 m3 都表示字符串，但是他们表达的并不一样

    // 首先来看m3，程序会在内存中分配长度14的数组，最后一位是\0 , 前面13位就是char的默认类型，
    // 字符串存在静态存储区，程序开始运行时，才会分配数组的内存，然后将字符串拷贝到数组中，
    // 此时，字符串会有两个副本，一个在静态存储区，另一个在数组中


    // p3 的运行，字符串也是在静态存储区，然后还要开辟一个指针的空间，然后把字符串的地址存给指针

    // 总之， 初始化数组把静态存储区的字符串拷贝到数组中， 而初始化指针只把字符串的地址拷贝给指针。


    printf("the address of [Helloworld!] = %p \n ","Helloworld!");   //可以发现这里的打印是和p3 的内容是一样的
    printf("the address of m3 %p \n", m3);
    printf("the address of p3 %p \n", p3);
    
    
    printf("the string of p3 %s \n", p3);  // 这里要注意   


    // 指针和数组的区别

    char heart[] = "I love Tillie!";
    const char *head = "I love Millie!";


    // 都能进行指针操作和数组的下标操作，这里不做演示
    // 区别：
    // 1. 只有指针能做++ 操作 ，比如 *(head++)
    // 2. 数组的元素是变量（除非数组被声明为const） ， 但是数组名不是变量。


//    char *ppp = "Cocoa";     
//    ppp[0] = 'K';     //无法运行
//     printf("the ppp = %s \n", ppp);
//     printf("the Cocoa = %s \n", "Cocoa");   // 可能会导致静态存储区的字符串发生改变

    // 推荐在指针字符串前加上const
    const char *p999 = "Hello";



    return 0;
}