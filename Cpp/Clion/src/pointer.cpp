#include "pointer.h"
#include <iostream>
using namespace std;

void test(int *p){

    cout<< &p  << endl;   // 这里指针做了拷贝，所以这里形参和实参的指针地址是不一样的
    cout<< p  << endl;    // 但是指针所指向的地址是一致的


}




void test(){


    int a = 10;
    int *p = &a;

    test(p);

    cout<< &p  << endl;
    cout<< p  << endl;



}

