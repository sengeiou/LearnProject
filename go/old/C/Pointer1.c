#include <stdio.h>

int main()
{
	int i=0;
	int array[5] = {1,3,5,7,9} ;
		
	for(i = 0; i < 5; i ++)
	{
		printf("%d \n", &array[i]);
	}


	int *p = array;
	//这里比较容易搞混，++放在后面，首先会取p的值，p =&a[0], *p = 1 ，所以输出 1，后面再做++操作
	printf("p====> %d \n", *(p++));
	//然后这里再取一次p的值，输出为3，因为是已经++后的
	printf("p====> %d \n", *(p));

	//还可以试下下面的代码，++在前，先++p然后在取值，等于*(p+1) 输出的值为3 
	//printf("p====> %d \n", *(++p));
	
	p = array; 

	printf("p====> %d \n", *p++);

	int j = 0;
	p = array;
	printf("for each array \n");



	for(j =0; p <= array+4;j++){
		printf("%dp====> %d \n",j, *p++);
	}

	p = array;
	//****很重要的用指针遍历数组
	//****很重要的用指针遍历数组
	//效率很高
	while(p <= array+4){
		printf("p====> %d \n", *p++);
	}


	// int u =1;
	// int xx = 2*(++u);
	// printf("%d d= %d  \n", xx,u);


	return 0;

}
