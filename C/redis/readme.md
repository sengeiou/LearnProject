# test1.c  void 类型  
 <!-- int a = 10;
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
     -->

参考文档 
https://www.runoob.com/w3cnote/c-void-intro.html
http://redisbook.com/errata/chp3.html

* void 指针可以指向任意类型，就是说可以用任意类型的指针对 void 指针对 void 指针赋值
* 在代码中，我们把p1 （int类型的指针）赋值给指针 p2 (void 类型的指针)，可以正常运行，无报错
* 如果尝试打印 p2 的值，则要进行进行强转 *((int*)p2) ,尝试了下别的办法，好像不行
* 在 ANSI C 标准中，不允许对 void 指针进行一些算术运算如 p++ 或 p+=1 等 , 因为不确定void 指针是几个字节，
    而在 GNU 中则允许，因为在默认情况下，GNU 认为 void* 和 char* 一样，既然是确定的，当然可以进行一些算术操作，
    但是实际运行中，发现不会报错，尽量少做这类操作吧

* 在代码中，是不能直接申明void 类型的， 比如 void bbb ; 在编译期就会报错。即使不出错也没任何意义，所以不要写
*    