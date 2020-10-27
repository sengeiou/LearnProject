#include <iostream>


using  namespace  std;


int compare(int x , int y){
    return x  - y;
}

void change(int x ){
    x = 10;
    cout << "change " << x << endl;
}

int main() {


    cout << "Hello, World!" << std::endl;

    int yaml[3];
    yaml[0] = 10;
    yaml[1] = 20;

    cout << yaml[2] << "\n" <<  yaml[1] <<endl;


    cout << compare(10,20) << endl;

    int a  =  222;
    change(a);
    cout << a << endl;


    return 0;
}




