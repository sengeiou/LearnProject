#include <iostream>

using namespace std;



class A
{
  public:
  int i;
  A(){
    cout <<"constructs"<< endl;
    i = 999;
  };
  int getI(){
    return i;
  }

  private:
  int j;

};


int main()
{

  // creata object at heap
    A *p = new A;
    cout << p->i << endl;
    int result = p->getI();
    cout << result << endl;
    cout <<"endl"<< endl;

    delete p ;

    return 0;
}
