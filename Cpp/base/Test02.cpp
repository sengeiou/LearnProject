#include <iostream>
#include <cmath>
using namespace std;

int a  = 100;

// 双冒号作用域扩展   :: 取全局变量
int test(){
    int  a   = 200;
    cout << "a=" << a << endl;
    cout <<  "::a="<< ::a << endl;
    // cout <<  "::b="<< ::b << endl;
    cout << sqrt(a) << endl;
}


int main(){
    test();
}
