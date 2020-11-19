#include <stdio.h>
#include <stdlib.h>


#define pf printf   // define 替换关键字
#define DEBUG 0   
#define TEST_FLAG 1
#define C(a) pf("define C a  = %d\n",a)   // 带参数的


#if DEBUG 
    printf1(int a) { printf("the a = %d\n", a);  };    
#else    // 这里也可以使用#elif
    printf1(int a){ printf("the a = %d\n", a * a); }    
#endif


#if TEST_FLAG
    
#endif



int main(){

    pf("start----\n");



    printf1(10);

    #ifndef TEST_FLAG
        pf("the test_flag not defined! \n");    
    #endif


    C(10);    


    return EXIT_SUCCESS;
}
