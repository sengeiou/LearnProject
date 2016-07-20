#include <stdio.h>


struct point{
  int x;
  int y;
};


struct point makepoint(int x, int y ){

  struct point  p;

  p.x = x;
  p.y= y;
  return p;
}



int main(){

  struct point p ={100,100};

  printf("%d\n", p.x );

  struct point  p1 = makepoint(1,1);

  printf("%d  \n", p1.x);

  return 0;
}
