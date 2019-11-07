#include <stdio.h>
#include <stdlib.h>
#include <string.h>
// #include <math.h>

struct redis_sds
{
    size_t len;
    size_t free;
    char buff[];
};

typedef struct redis_sds sds;

sds *make(char *str, size_t len)
{
    size_t strLen = strlen(str); 
    size_t realLen = strLen > len ? strLen: len;
    sds *s = (sds *)malloc(sizeof(sds));
    s->len = realLen;
    s->free = realLen - strLen;
    strcpy(s->buff, str);
    return s;
}

void printSds(sds* s){
    printf("the sds len is %ld ,free is %ld and the buff is %s \n", s-> len ,s-> free, s-> buff);
}


// 结构体创建 redis sds
int main()
{

    sds *sds_p = make("123", 10);
    printSds(sds_p);


    return EXIT_SUCCESS;
}
