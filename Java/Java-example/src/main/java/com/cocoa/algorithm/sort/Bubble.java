package com.cocoa.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class Bubble extends BaseSort {
    /**
     * https://www.toutiao.com/a6581362477269778958
     * 冒泡排序
     * 两遍for 循环， 交换位置即可
     * 1.最里层的for 每次对比当前位置和向后一位。大于后面的则交换，所以外层的第一次循环过后，数组的最大值在最右边了
     * 2.然后外层开始第2次循环，（里层的操作可以不用对比最后一位，对应代码中的i < array.length - j - 1;），
     * 外层的第2次循环结束后，数组的倒数第2个数就是数组中倒数第2大的数字
     */

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

    /**
     * 优化冒泡
     * 当 数组排了一半 ，但是结果为【1，2，3，4，5】,剩下的对比仍然会执行，所以在里层for 循环加了 isSorted 变量
     *
     * @param array
     */
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

//    这个问题的关键点在哪里呢？关键在于对数列有序区的界定。
//
//    按照现有的逻辑，有序区的长度和排序的轮数是相等的。比如第一轮排序过后的有序区长度是1，第二轮排序过后的有序区长度是2 ......
//
//    实际上，数列真正的有序区可能会大于这个长度，比如例子中仅仅第二轮，后面5个元素实际都已经属于有序区。因此后面的许多次元素比较是没有意义的。
//
//    如何避免这种情况呢？我们可以在每一轮排序的最后，记录下最后一次元素交换的位置，那个位置也就是无序数列的边界，再往后就是有序区了。
//

    /**
     * 当数组为 {1, 2, 4, 3, 6, 5, 7, 8, 9, 10}; 时，其实后面已经是有序数组了，
     * 优化冒泡2 记录最后一次的交换位置
     *
     * @param array
     */
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
