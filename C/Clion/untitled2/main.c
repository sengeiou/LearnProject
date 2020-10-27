#include <stdio.h>


struct Action{
    int id;
    int position;
};


int main() {
    int num = 2;
    struct Action *actions = (struct Action*) malloc(sizeof(struct Action) * num);


    struct Action a1={2,2500};
    struct Action a2={1,2500};

    actions= &a1;
    actions++;

    actions=&a2;
    actions--;



    for (uint8_t i = 0; i < 2; i++) { //循环填充舵机ID和对应目标位置
        printf("the p address  = %d \n", actions->id);
        printf("the p address  = %d \n", actions->position);

        actions++;
    }



    return 0;
}
