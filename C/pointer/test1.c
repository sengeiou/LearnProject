#include <stdio.h>

int main(){

  int i  = 10;
  int *p = &i;

  *p = *p +10;
  printf("%d\n", *p);



  return 0;
}
