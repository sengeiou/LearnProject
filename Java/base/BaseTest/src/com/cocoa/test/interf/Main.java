package com.cocoa.test.interf;

import java.nio.ByteBuffer;

/**
 * 1  接口中所有的方法都是public的，所有不需要在方法前加上public
 * 2  接口中可以定义常量，但是不能有实现方法
 * 3
 *
 *
 */
public class Main implements Comparable<Person>{


    public static final String DATE_FORMATER = "yyyy-MM-dd hh:mm:ss";

    public static void main(String[] args){

//        int[]  a = {1,2,3,4};
//
//        int[] b  = Arrays.copyOf(a,6);
//
//
//        for(int t :b) {
//            System.out.println(t);
//        }
//        long time = 0;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMATER, Locale.CHINA);
//        try {
//            Date date = simpleDateFormat.parse("2016-06-28 14:13:30");
//            time = date.getTime();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(time);
//        System.out.println(System.currentTimeMillis());


        ByteBuffer byteBuffer = ByteBuffer.allocate(12);

        byteBuffer.put((byte)'b');
        byteBuffer.put((byte)'b');
        byteBuffer.put((byte)'b');
        byteBuffer.put((byte)'b');
        byteBuffer.rewind();
        byteBuffer.flip();
        byteBuffer.hasRemaining();
        byteBuffer.compact();
        byteBuffer.mark();
        byteBuffer.reset();
    }




    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
