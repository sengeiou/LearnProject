#include <stdio.h>

int main(){
	int a  = 10;
	int *p = &a;
	*p = 11;
	printf("%d \n",*p-1);
	printf("%d \n",*(p+1));
	printf("%d \n",a);
	return 0;
}

