#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Sds SDS;
//https://github.com/redis/redis/blob/unstable/src/sds.c
struct Sds {
    int len;
    int free;
    char str[];
};

void change(char c[], char *p, size_t len) {
    for (int a  = 0; a< len; a ++){
        *(c+a) = *(p+a);
    }
    printf("%s\n", c);
}

SDS *init(char *str, size_t len) {
    SDS *s = (SDS *) malloc(sizeof(int) * 2 + sizeof(char) * (len + 1));
    s->len = len;
    s->free = 0;
    change(s->str, str, len + 1);
    return s;
}

void printSds(SDS *p) {
    if (p == NULL) {
        return;
    }
    printf("the len of sds = %d , and the free = %d, the content = %s \n", p->len, p->free, p->str);
}

void freeSds(SDS *p) {
    if (p == NULL) {
        return;
    }
    free(p);
    p = NULL;
}

SDS *append(SDS *p, char *str, size_t len) {
    size_t cutLen = p->len;
    if (len <= cutLen) {
        change(p->str, str, len + 1);
        return p;
    } else {
        freeSds(p);
        return init(str, len);
    }
}

int main() {

//    char s[] = "12312312";
//
//    char *c = "Hello";
//    change(s, c, strlen(c));


    char *str = "Helloworld!!!";
    size_t len = strlen(str);
    SDS *sds = init(str, len);
    printSds(sds);

    char *str2 = "User Defaults won't write to disk right away";
    SDS *s2 = append(sds, str2, strlen(str2));
    printSds(s2);

    freeSds(sds);
    freeSds(s2);

}