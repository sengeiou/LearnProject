#include <stdio.h>

int main()
{
  int a[10]={1};

  //printf("%ld \n", sizeof(a));
  int length  = sizeof(a)/sizeof(a[0]);
  for(int i = 0; i< length ;i++){
    printf("%d \n", a[i]);
  }
  //未经过初始化的数组，内容往往是不确定的
  //但是，只要你初始化后，哪怕只初始化数组中的一个元素
  //编译器也会自动的为每个元素初始化
  //初始值参考类型的的默认初始值

  return 0;
}
