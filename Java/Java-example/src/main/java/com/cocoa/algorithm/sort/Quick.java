package com.cocoa.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class Quick extends BaseSort{

    @Test
    public void test() {
        int[] a = randomArray();
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }


    private void quickSort(int[] array, int left, int right) {
        int low = left;
        int high = right;
        while (low < high) {
            high--;
            if (array[low] > array[high]) {
                swap(array, low, high);
                low++;
            }

        }
        while (low < high) {
            low++;
            if (array[low] > array[high]) {
                swap(array, low, high);
                high--;
            }
        }
        System.out.println(low+"--"+high);
    }

    public void sort(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= povit)
                h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }

            while (l < h && arr[l] <= povit)
                l++;

            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        System.out.println(l+"---"+h);
        System.out.println(Arrays.toString(arr));
//        if (l > low) sort(arr, low, l - 1);
//        if (h < high) sort(arr, l + 1, high);
    }


}
