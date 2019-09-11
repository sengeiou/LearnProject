package com.cocoa.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class Select extends BaseSort {
    @Test
    public void test(){
        int[] array = randomArray();
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    public void selectSort(int[] arr){
        for(int i =0; i< arr.length -1;i++){
            int minIndex = i;
            for(int j = i+1;j < arr.length;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }



}
