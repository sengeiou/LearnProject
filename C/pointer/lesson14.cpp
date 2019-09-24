#include  <iostream>

using namespace  std;

class A
{
public:
  A();
  int i;
  ~A();
  int getP(){
    return *p;
  }
private:
  int *p;
};


int main(){

  A *a = new A;

  cout<< a->getP() <<endl;

  delete a;
  
  return 0;
};

A::A(){
   p = new int;
  cout<< "constructs" <<endl;
};

A::~A(){
  delete p ;
  cout<< "xigou" <<endl;
};
