#include <stdio.h>
#include <string.h>

int main(int argc, char* argv[]){
	printf("%s \n", *argv);
	printf("%d \n",argc);
	char* c = "123";
	printf("the lenght is %ld \n",strlen(c));
}

