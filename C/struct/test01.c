#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>


struct person
{
    char *name;
    int age;
    int height;
    int weight;
};

struct person *createPerson(char *name, int age, int height, int weight)
{
    struct person *p = (struct person *)malloc(sizeof(struct person));
    p->name = (char *)malloc(20);
    strcpy(p->name, name);
    p->age = age;
    p->weight = weight;
    p->height = height;
    return p;
}
// 使用方法创建结构体指针，并卓一销毁
int main()
{
    struct person *p = createPerson("cocoa", 12, 180, 80);
    printf("the p address  = %p \n", p);
    free(p->name);
    free(p);
    p = NULL;

   int result =  socket(AF_INET,SOCK_STREAM,9999);
    printf("the result is %d \n", result);
    return EXIT_SUCCESS;
}