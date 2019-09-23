#include <stdio.h>

int main(){

    int arr[5] = {1,2,3,4,5};

    int *p = &arr[4];
    printf("%ld--\n",p-arr);



    int *p1 = &arr[0];
    int *p2 = &arr[4];

    while(p1 != p2){
        p1++;
        p2--;        
    }

    printf("%d--\n",*p1);
    return 0;
}
