#include <iostream>

using namespace std;


int main()
{
  int a = 10;
  int &ra  = a;

  std::cout << a << std::endl;
  std::cout << ra << std::endl;

  ra = 100;

  std::cout << a << std::endl;
  std::cout << ra << std::endl;

  a =1000;

  std::cout << a << std::endl;
  std::cout << ra << std::endl;


  //address always equals
  std::cout << &a << std::endl;
  std::cout << &ra << std::endl;

  return 0;
}
