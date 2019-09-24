#include <stdio.h>

int main()
{

	int i = 0;
	int array[5] = {2,3,4,6,8};

	int *p = array;
	int *p2 = &array[2];


	for(i = 0; i < 5; i ++)
	{
		printf("%d \n", &array[i]);
	}


	printf("%d \n", *p);
	printf("%d \n", p2-p);


	return 0;
}
