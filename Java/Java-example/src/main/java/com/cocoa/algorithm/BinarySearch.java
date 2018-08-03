package com.cocoa.algorithm;

import org.junit.Test;

import java.util.Arrays;

public class BinarySearch {

    @Test
    public void test() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result = Arrays.binarySearch(array, 16);
        System.out.println(result);
        result = binarySearch(array,16);
        System.out.println(result);


        // 这里解释了为什么 middle 的/2 要用  >>>1 ，防止溢出
        int test = 10 + Integer.MAX_VALUE;
        System.out.println(test >>> 1);
        System.out.println(test / 2);
    }

    /**
     * 二分查找
     * @param array
     * @param key
     * @return
     */
    private int binarySearch(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int low = 0;
        int hight = array.length - 1;
        while (low <= hight) {
            int middle = (low + hight) >>> 1;
            if (array[middle] == key) {
                return middle;
            } else if (array[middle] < key) {
                low = middle + 1;
            } else if (array[middle] > key) {
                hight = middle - 1;
            }
        }
        return -1;
    }


}
//        278. First Bad Version：Easy。注意位运算符优先级。
//        230. Kth Smallest Element in a BST：Medium。利用二叉查找树的特点。
//        35. Search Insert Position：Medium。lower_bound。
//        153. Find Minimum in Rotated Sorted Array&旋转数组的最小数字：Medium。很不错的二分查找变形题目。不熟悉。
//        74. Search a 2D Matrix&240. Search a 2D Matrix II：Medium。二分查找变形。
//        300. Longest Increasing Subsequence：Medium。动态规划的方法比较普通，二分查找的方法比较新颖。不熟悉。
//        162. Find Peak Element：Medium。不熟悉。
//        50. Pow(x,n)&数值的整数次方：Medium。分治法，不知道跟二分查找什么关系。不熟悉。
//        275. H-Index II：Medium。不熟悉。
//        81. Search in Rotated Sorted Array II：Medium。与153.Find Minimum in Rotated Sorted Array&旋转数组的最小数字类似。不熟悉。
//        34. Search for a Range：Medium。lower_bound和upper_bound。不熟悉。
//        209. Minimum Size Subarray Sum：Medium。滑动窗口和二分查找两种方法。不熟悉。
//        69. Sqrt(x)：Medium。不熟悉。
//        222. Count Complete Tree Nodes：Medium。搞清楚完全二叉树、满二叉树的概念。递归方法简单。二分查找法不熟悉。
//        29. Divide Two Integers：Medium。非常不熟悉的题目。