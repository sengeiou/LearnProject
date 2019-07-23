#include <stdio.h>
#include <string.h>
#define COCOA "cocoa"

int main(){
    char name[40];
    // scan can only read one word
    scanf("%s",name);
    printf("%s %s \n",name ,COCOA);
 
    printf("name length is %ld and sizeof is %ld", strlen(name), sizeof name);
    return 0;
}