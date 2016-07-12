#include <iostream>
using namespace std;

// this

class A{

public:
  void getP(){
    cout<< this <<endl;
  };


};



int main()
{
  A *a  = new A;
  a->getP() ;
  cout<< a <<endl;
  return 0;
}
