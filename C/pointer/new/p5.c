#include <stdio.h>

#define SIZE 5

void xx(int arr[],int num){
	for(int i = 0; i< SIZE; i++){
		arr[] += num;
	}
	for(int i = 0; i< SIZE; i++){
		printf("%d \n",arr[i]);
	}
}


void usePointer(int *arr,int num){
	for(int i = 0; i< SIZE; i++){
		*(arr+i) += num;
	}
	for(int i = 0; i< SIZE; i++){
		printf("%d \n",*(arr+i));
	}
}

int main(){
	int arr[SIZE]= {1,2,3,4,5};
	usePointer(arr,10);
	printf("before change \n");
	for(int i = 0; i< SIZE; i++){
		printf("%d \n",arr[i]);
	}
}
