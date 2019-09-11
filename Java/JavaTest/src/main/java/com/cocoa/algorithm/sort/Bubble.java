package com.cocoa.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class Bubble extends BaseSort {

    @Test
    public void test() {
        int[] a = randomArray();
        optSort2(a);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] array) {
        int count = 0;
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - j - 1; i++) {
                count++;
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
        System.out.println(count);
    }

    public void optSort1(int[] array) {
        int count = 0;
        for (int j = 0; j < array.length; j++) {
            boolean isSorted = true;
            for (int i = 0; i < array.length - j - 1; i++) {
                count++;
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                System.out.println(count);
                break;
            }
        }
    }

    public void optSort2(int[] array) {
        int count = 0;
        int sortLength = array.length - 1;
        int lastChangeIndex = 0;
        for (int j = 0; j < array.length; j++) {
            boolean isSorted = true;
            for (int i = 0; i < sortLength; i++) {
                count++;
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                    lastChangeIndex = i;
                }
            }
            sortLength = lastChangeIndex;
            if (isSorted) {
                break;
            }
        }
        System.out.println(count);
    }


}
