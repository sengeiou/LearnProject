#include <stdio.h>
#include <string.h>

int main(){
    char* h1 = "Hemm";
    char* h2 = "Hemm";

    int result =  strcmp(h1,h2);
    printf("%d\n",result);

    return 0;
}