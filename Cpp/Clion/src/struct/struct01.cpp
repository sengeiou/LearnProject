//
// Created by Administrator on 2020/11/6.
//

#include "struct01.h"

struct Person {
    int age;
    char* name;
};

void struct01Test() {

    struct Person *p = (struct Person *) malloc(sizeof(struct Person) * 3);
    struct Person *header = p;

    p->age = 12;
    p->name = "123";
    p++;
    p->age = 13;
    p->name = "223";


    for (int i = 0; i < 3; ++i) {
        struct Person *t = header + i;
        cout << t->age << "  & name ="<< t->name << endl;
    }


}