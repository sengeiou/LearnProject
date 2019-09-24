#include <stdio.h>

int main(){

  int a = 10;
  double b  = 20.0;


  int *p1 = &a;
  double *p2 = &b;
  //指针的类型必须与变量的类型相匹配
  // 假如不相同，编译无法通过

  return 0;
}
