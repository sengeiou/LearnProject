package com.cocoa.algorithm.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class BaseSort {

    protected int[] testArray1 = {1, 2, 4, 8, 7, 6, 5, 9, 3, 10};
    protected int[] testArray2 = {11, 2, 4, 3, 6, 5, 7, 8, 9, 10};
    Random random = new Random();
    public static final int MAX_LENGTH = 30;

    public int[] randomArray() {
        return randomArray(new Random().nextInt(MAX_LENGTH) + MAX_LENGTH);
    }

    public int[] randomArray(int size) {
        int length = Math.abs(size);
        System.out.println(length);
        int[] array = new int[length];
        HashMap<Integer, Object> keys = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int temp = random.nextInt(size + size);
            while (keys.containsKey(temp)) {
                temp = random.nextInt(size + size);
            }
            array[i] = temp;
            keys.put(temp, temp);
        }
        System.out.println(String.format("random create array %s", Arrays.toString(array)));
        return array;
    }


    public void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }


}
