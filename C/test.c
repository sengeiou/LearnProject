#include <stdio.h>

int main(){

     int a , **ap;
    // ap = &(&a);

    int *p = &a;
    ap = &p;

    char* str = "Hello";
    for (int i = 0; i < 5; i++)
    {
        printf("%c", *(str+i));
    }
    printf("\n");

    FILE *f  = fopen("123.txt","rw");
    if(f){
        char c ;
        for (;;)
        {
             c  = fgetc(f);
             if(feof(f)){
                 break;
             }   
             printf("%c",c);
        }
    }    
    printf("\n the file is %p \n", f);
    fclose(f);
    printf("\n");
    return -1;
}
