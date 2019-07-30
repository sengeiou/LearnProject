#include <stdio.h>

int main(){
	FILE *fp;
	fp = fopen("test.txt","rw");
	char c = fgetc(fp);
	while(c != EOF){
		printf("%c",c);
		c = fgetc(fp);
	}
	return 0;
}
