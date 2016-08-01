#include <stdio.h>

void swap(int x,int y ){
  int temp = x;
  x = y;
  y= temp;
  printf("x= %d   y=%d \n ",x,y );
}

void swapUsePointer(int *x ,int *y){
    int *p =  x;
    x = y;
    y = p ;
    printf("x= %d   y=%d \n ",*x,*y);
    printf("x= %p   y=%p \n ",x,y );
}

void swapUsePointer1(int *x ,int *y){
    int p =  *x;
    *x = *y;
    *y = p ;
    printf("x= %d   y=%d \n ",*x,*y );
    printf("x= %p   y=%p \n ",x,y );

}



int main(){

  int x = 10;
  int y = 20;
  printf("x= %d   y=%d \n ",x,y );
  printf("x= %p   y=%p \n ",&x,&y );
  swapUsePointer1(&x,&y);
  printf("x= %d   y=%d \n ",x,y );
  printf("x= %p   y=%p \n ",&x,&y );

  return 0;
}
