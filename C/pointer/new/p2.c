#include <stdio.h>

void test(int *a){
	for(int i = 0 ;i < 3 ;i++){
		printf("%d ----%p\n",*(a+i),a+i);
	}
}

int main(){
	int a[] = {11,22,33};		
	test(a);
	return 0;
}


