#include <stdio.h>

void append(char* str1, char* str2){
    while(*str1){
        str1++;
    }
    // while( *str1++ = *str2++);
    // 上面这句在mac 端无法编译
    while(*str2){
        *str1 = *str2;
        str1++;
        str2++;
    }

}
// 追加字符串
int main(){
    char* ss = "123";
    char s2[20] = "ssss";
    append(s2,ss);
    printf("%s \n",s2);

    return 0;
}