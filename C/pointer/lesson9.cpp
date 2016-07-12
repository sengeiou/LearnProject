#include <iostream>

using namespace std;

// at this lesson ,we use replace c to c++ file
// user command  g++ lesson9.app to compile
int main()
{

    double *d = new double;
    delete d ;  // delele
    cout << d << endl;
    //必须要delete后，才能重新赋值，不然会造成内存泄漏
    d = new double;
    cout << d<< endl;
    return 0;
}
