#include <stdio.h>

int main(){

  int a[4] ={0,1,2,3};

  int *pa =  &a[0];


//  printf("&a[0] %p\n", &a[0]);
//  printf("&a[1] %p\n", &a[1]);


//  printf("++pa   %p\n", ++pa);

//  printf(" *(++pa) %d\n", *(++pa));


  for(int i = 0; i< 4 ;i++){
    printf("%d\n", *(pa+i));
  }




  return 0;
}
