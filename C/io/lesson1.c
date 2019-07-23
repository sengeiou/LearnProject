#include <stdio.h>
#include <stdlib.h>

int main(){

  int ch;
  FILE *fp ;
  long count ;

  if((fp = fopen("test.txt","r")) == NULL)
  {

    printf("null file " );
  }
  else
  {
      printf("ok");
  }

  while((ch =getc(fp))!= EOF)
  {
    printf("%c\n",ch);
    count++;
  }

  fclose(fp);




  return  0;
}
