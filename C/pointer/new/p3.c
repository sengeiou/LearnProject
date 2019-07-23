#include <stdio.h>
#define SIZE 10

int sum1(int *p, int size){
	int sum  = 0;
	for(int i = 0; i < size ; i++){
		sum += *(p+i);		
	}	
	return sum;
}
// use double pointer
int sum2(int *start ,int *end){
	int sum  = 0;
	while(start != end){
		sum += *start ;
		start++;
	}
	return sum;
}

int main(){
		
	int array[] = {1,3,4324,3,4,5,5,6,10,11};
	printf("sum1 is %d \n",sum1(array,SIZE));

	// the array index is 0 , so array+ index = end
	printf("sum2 is %d \n",sum2(array,array+SIZE));

	return 0;
}
