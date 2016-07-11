#include <stdio.h>

int main()
{

  int a =10;
  printf("%d \n",a);

  int *p = &a;



  printf("%p \n", &a);

  printf("%p \n", p);
  printf("%d \n", *p);
  printf("%p \n", &p);
  return 0;
}
