#include <stdio.h>

char* findKw(char* str, char kw){
	int step = 0;
	while(*(str + step ) != '\0' ){
		if(*(str + step) == kw ){
			return str + step;
		}
		step++;
	}
	return NULL;

}

int main(){
	char str[] = "Hello.world";
	char* result = findKw(str,'a');
	if(result == NULL){
		printf("cant find keyword \n");
	}else{
		printf("find the address %p ", result);
	}
	return 1;
}

