package com.cocoa.collection;

import java.util.Arrays;
import java.util.LinkedList;

public class TestList {

    public static void main(String[] args) {

        String[] srcArray = new String[5];
        for (int i = 0; i < srcArray.length; i++) {
            srcArray[i] = String.valueOf(i);
        }

        String[] destArray = new String[10];

        System.arraycopy(srcArray, 0, destArray, 0, srcArray.length);

        String result = Arrays.toString(destArray);

        System.out.println(result);

        // ArratList 的底层数组的扩展还有 trimToSize 方法，就是调用了 System.arraycopy 来进行扩展的

        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("123");
        linkedList.add("223");
        linkedList.add("323");
        linkedList.add("423");

        for(String str : linkedList){
            System.out.println(str);
        }


    }


}
