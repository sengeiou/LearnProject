#include <stdio.h>
#include <string.h>



void copy(char* p1, char* p2, int length){
    while ((*p1++ = *p2++) && --length);
}




int main(){

    char str1[] = "123";
    char str2[10];
    strcpy(str2,str1);  // 字符串拷贝  参数1 是目标字符串 参数2 是源字符串
    // 拷贝的时候注意， str2 的长度必须大于等于 str1.length + 1

    char str3[] = "sdfkhdasdasd";
    char str4[100];
    copy(str4,str3,2);

    printf("%s\n",str4);
    printf("%s\n",str2);

    return 0;
}