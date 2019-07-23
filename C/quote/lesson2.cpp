#include <iostream>

//change quote
int main()
{
  int a = 1;
  int &ra  = a ;

  std::cout << a << std::endl;
  std::cout << ra << std::endl;

  int b =100;

  ra  = b;
  std::cout << a << std::endl;
  std::cout << ra << std::endl;
  std::cout << b << std::endl;

  ra  = 1000;
  std::cout << a << std::endl;
  std::cout << ra << std::endl;
  std::cout << b << std::endl;



  std::cout << &a << std::endl;
  std::cout << &ra << std::endl;
  std::cout << &b << std::endl;






  return 0;
}
