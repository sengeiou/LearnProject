#include <stdio.h>
#include <string.h>


// 字符串逆置
void invers(char* str){
    int length = strlen(str);
    printf("the len is %d\n",length);

    char* start = str;    
    char* end = start + strlen(str) -1 ;
    while(start < end){
        char t = *start;          
        *start = *end;
        *end = t;
        start++;
        end--;
    }
}


int main(){

    char str[] = "cocoa";
    invers(str);
    printf("%s\n",str);
    return 0;
}