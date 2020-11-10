#include <stdio.h>
#include <string.h>

int main(){

    char* st1 = "Hello cocoa!";
    char* st2 = "co";

    char* index = strstr(st1, st2);
    printf("%s\n", index);
    return 0;   
}