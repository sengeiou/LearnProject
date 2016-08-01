#include <stdio.h>
#include <string.h>

int binsearch(int x,int v[],int n);


struct book{
  char *name;
  int count;
} books[]={
  {"java",0},
  {"C++",0},
  {"NodeJS",0},
  {"Golang",0}
};


int main(){
  int findTemp  = 2;
  int a[3]= {1,2,3};
  int index = binsearch(findTemp,a,3);

  printf("%d\n", index);


  return 0;
}


int binsearch(int x, int v[], int n)
{
   int low, high, mid;
   low = 0;
   high = n - 1;
   while (low <= high) {
       mid = (low+high)/2;
       if (x < v[mid])
           high = mid + 1;
       else if (x  > v[mid])
           low = mid + 1;
       else    /* found match */
           return mid;
   }
   return -1;   /* no match */
}
