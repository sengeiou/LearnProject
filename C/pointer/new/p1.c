#include <stdio.h>

#define SIZE 4

int main(){
	short dates[SIZE];
	short *pti;
	short index;
	double bills[SIZE];	
	double *ptf;
	pti = dates;
	ptf = bills;
	
	for (index = 0 ; index < SIZE; index++){
		printf("pointer + %d %10p %10p\n",index,pti+ index , ptf+ index);
	}
	printf("%d-- %d",*dates, *dates+1);
	return 0;

}
