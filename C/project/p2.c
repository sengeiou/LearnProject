#include <stdio.h>

int main(){
	FILE *fp;
	fp = fopen("test.txt","rw");	
	char buffer[100];
	fread(buffer,10,2,fp);	
	
	printf("%s",buffer);
	return 0;
}
