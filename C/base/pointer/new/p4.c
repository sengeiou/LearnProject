#include <stdio.h>

void mergeString(char* str1, char* str2){
	int num = 0;
	while(*(str1 + num) != '\0'){
		num ++;
	}

	int index= 0;
	while(*(str2+ index) != '\0'){
		*(str1+ num + index) = *(str2+ index);
		index++;

	}
	*(str1+num+index) = '\0';
}

int main(){
	char str1[] = "Hello";
	char str2[] = "cocoa";

	mergeString(str1,str2);
	printf("%s \n",str1);

	return 1;
}

