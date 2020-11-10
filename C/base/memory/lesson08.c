#include <stdio.h>
#include <stdlib.h>
#include <string.h>


//memset 还不是很理解  https://www.bilibili.com/video/av55251178/?p=25
int main(){


    int* c1 = (int*) malloc(10 * sizeof(int));
    memset(c1,1,sizeof(c1));

    for (int i = 0; i < 10; i++)
    {
        /* code */
        printf("%d \n", c1[i]);
    }
    
    return EXIT_SUCCESS;
}
