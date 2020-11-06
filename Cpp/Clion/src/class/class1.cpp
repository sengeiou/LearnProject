//
// Created by Administrator on 2020/10/28.
//
#include "class1.h"
#include <string>

class Person{



private :
    int mAge;
    string mName;


public:
    string getName(){
        return mName;
    }

    void setName(string name){
        this->mName  = name;
    }

    void save();

    Person(string name , int age){
           mName = name;
           mAge = age;
    }

    Person(){
        mName = "default";
        mAge = 0;
    }
    ~Person(){
        cout<<"person has release!!"<<endl;
    }

};


void Person::save(){
   cout<< mName <<endl;
};


int compare(int a , int* p){
    return  a > *p ? a : *p;
}



void  testClass(){

    Person  p = Person("cocoa",12);
    p.setName("123");
    cout<< p.getName() << endl;

    p.save();

    cout<<"Hello"<<endl;

    cout<<"----------------------------"<<endl;

    Person newP = Person();

    cout<<newP.getName()<<endl;

    int a  = 10;
    int b = 11;
    cout<<"the max number is "<<compare(a, &b) <<endl;

}