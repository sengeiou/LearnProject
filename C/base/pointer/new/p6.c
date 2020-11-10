#include <stdio.h>

int main(){
	char c[] = "Hello";  // 栈区字符串
	char* p = "Hello";  // 数据区常量字符串
	char* p1 = "Hello";

	printf("%p \n", p);
	printf("%s \n", p);

	printf("p1 and p  %p %p \n", p,p1); 
	printf("p1 and p  %p %p \n", &p,&p1); 

	// 两者的区别， 常亮区字符串无法修改, 下面的代码会在运行期报错
	*(p+1) = 'x';

	printf("change p %s \n",p);

	return 1;


}
