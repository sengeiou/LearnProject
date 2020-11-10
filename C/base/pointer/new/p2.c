#include <stdio.h>

void test(int *array){
	printf("the array size is %ld", sizeof(array));

}

int main(){
	int arr[] = {1,2,3,4,5};
	int *p = arr;	
	printf("%p\n",p);
	int size  = sizeof(arr)/sizeof(arr[0]);

	*(p+1) = 100;

	for(int i = 0; i < size; i++){
		printf("%d===%p\n",arr[i],p+i);
	}

	test(arr);

	return 1;
}


