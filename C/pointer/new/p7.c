#include <stdio.h>

int main(){
	char* str = "Hello";

	*(str+1) = 'C';
	for(int i = 0; i < 5; i++){
		printf("%d\n",*(str+i));
	}

	return 1;
}
