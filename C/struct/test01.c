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

struct Action{
    uint8_t id;
    uint16_t position;
};


// 使用方法创建结构体指针，并卓一销毁
int main()
{
//     struct person *p = createPerson("cocoa", 12, 180, 80);
//     printf("the p address  = %p \n", p);
//     free(p->name);
//     free(p);
//     p = NULL;

//    int result =  socket(AF_INET,SOCK_STREAM,9999);
//     printf("the result is %d \n", result);
    int num  = 2;
    struct Action *actions = (struct Action*) malloc(sizeof(struct Action) * num);
    

    struct Action a1={2,2500};
    struct Action a2={1,2500};
    
    actions->id = 2;
    actions->position = 2500;
    actions++;

    // actions=&a2;
    // actions--;
    actions->id = 1;
    actions->position = 2500; 
    actions--;
    

    for (uint8_t i = 0; i < 2; i++) { //循环填充舵机ID和对应目标位置
    printf("the p address  = %d \n", actions->id);
    printf("the p address  = %d \n", actions->position);
   
    actions++;
  }


    return EXIT_SUCCESS;
}