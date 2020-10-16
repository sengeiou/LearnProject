#include <stdio.h>

#define SIZE 10

int main()
{
  int a[SIZE]={1};

  //printf("%ld \n", sizeof(a));
  // 使用sizeof 可以计算数组的长度，但是在函数内是不允许这样的，因为函数内部传入的是数组的指针
  int length  = sizeof(a)/sizeof(a[0]);
  for(int i = 0; i< length ;i++){
    printf("%d \n", a[i]);
  }

  printf("-------------------");

  int b[SIZE];
  for (int i = 0; i < SIZE; i++)
  {
    printf("%d \n", b[i]);
  }


  //未经过初始化的数组，内容往往是不确定的
  //但是，只要你初始化后，哪怕只初始化数组中的一个元素
  //编译器也会自动的为每个元素初始化
  //初始值参考类型的的默认初始值
  // 对比  a 和 b 输出就可以发现


// 1 
// 0
// 0
// 0
// 0
// 0
// 0
// 0
// 0
// 0
// ----------------------
// 1229148993
// 73
// -2145684838
// 1
// -13200
// 0
// -13200 
// 0
// -13200
// 0


  printf("-------------------");
  // c99  指定初始化器

  int arr[SIZE]= {[5] = 99};
 for (int i = 0; i < SIZE; i++)
  {
    printf("%d \n", arr[i]);
  }


  printf("-------------------");
  // C99 前不允许这么创建数组
  int n  = 10;
  int intArray[n];





  return 0;
}
