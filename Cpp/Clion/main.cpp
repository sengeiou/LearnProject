#include <iostream>
#include "src/pointer.h"

using  namespace  std;

//https://www.bilibili.com/video/BV1et411b73Z?p=60

int compare(int x , int y){
    return x  - y;
}

void change(int x ){
    x = 10;
    cout << "change " << x << endl;
}

int main() {


    test();

    int yaml[3];
    yaml[0] = 10;
    yaml[1] = 20;

    cout << yaml[2] << "\n" <<  yaml[1] <<endl;


    cout << compare(10,20) << endl;

    int a  =  222;
    change(a);
    cout << a << endl;


    int x = 10;
    int *p = &x;
    cout<< p <<endl;
    cout<< *p <<endl;
    cout<< &x <<endl;
    cout<< sizeof(p) <<endl;
    cout<< sizeof(*p) <<endl;
    cout<< sizeof(int*) <<endl;
    cout<< sizeof(int) <<endl;


    return 0;
}




