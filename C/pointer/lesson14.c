#include <stdio.h>

// 指针数组 的操作 ，重点看 line12，13，24，27
int main(void)
{
    int a = 10;
    int b = 20;
    int c = 30;
    int *array[3] = {&a, &b, &c};
    for (int i = 0; i < 3; i++)
    {
        printf("%p---", *(array + i));
        printf("%d\n", **(array + i));
    }

    int x[3] = {1, 2, 3};
    int y[3] = {4, 5, 6};
    int z[3] = {7, 8, 9};

    int *arr[3] = {x, y, z};

    for (int i = 0; i < 3; i++)
    {
        int *p = *(arr + i);
        for (int j = 0; j < 3; j++)
        {
            printf("%d", *(p + j));
        }
    }

    return 0;
}