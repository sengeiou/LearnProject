#include <stdio.h>
#include <string.h>

int main(int argc, char* argv[]){
	printf("%s \n", *argv);
	printf("%d \n",argc);
	char* c = "123";
	printf("the lenght is %ld \n",strlen(c));

	char* str = "Hello";
	//下面这句话编辑期不会报错，运行期会报错，因为str 申明的是在常量池的，无法修改， 而char str[] 则可以修改
	*(str+1) = 'C';
	for(int i = 0; i < 5; i++){
		printf("%d\n",*(str+i));
	}

	return 1;
}
