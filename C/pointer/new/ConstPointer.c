#include <stdio.h>


int main(){
	test2();
	retutn 1;
}

void test1(){
	int a = 10;
	int b = 20;
	const int* p = &a;
	p = &b;

	*p = b;
}

void test2(){

	int a  = 10;
	int b = 20;
	int* const p = &a;
	*p = b;

	p = &b;	

}

