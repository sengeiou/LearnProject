#include <stdio.h>

void test(void)
{
	printf("\n123\n");
}
int main()
{
	int a[10] = {1, 2, 3};

	printf("%d", a[1]);

	// list array

	for (int i = 0; i < 3; i++)
	{
		printf("%d", a[i]);
	}
	test();

	return 0;
}
