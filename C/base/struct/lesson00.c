#include <stdio.h>
#include <stdlib.h>
/**
关于结构的基本使用和初始化
但是还是有不理解的地方，比如结构里的字段是自身，结构里的字段默认的值（不设置默认值，好像是系统给的）

在所有的优先级中，下面4个的优先级最高，".","->","()","[]"
++p->x  可以看成是++（p->x），当然可以用括号改变    （++p）->x


*/
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


  struct point  x , *y;

  x.x = 1;
  x.y = 1;

  y = &x;

  printf("%d %d\n",y->x,y->y );

  // 对指针进行自增，理解优先级
  printf("%d %d\n",++y->y,(y++)->y );



  return 0;
}
