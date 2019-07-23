package com.company;

import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Main extends Thread {
    static File parentFile = new File("/Users/sj/Documents/kqc_pro/b2b-ii-android/app/build/intermediates/classes/dev/debug");

    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {

        @Override
        protected String initialValue() {
            // 设置初始值，这里使用当前thread的名字
            return Thread.currentThread().getName();
        }

    };

    public static void main(String[] args) {
//        if (parentFile.exists()) {
//            listDir(parentFile);
//        }


//        try {
//            Class clazz = Main.class;
//            Method[] methods = clazz.getDeclaredMethods();
//            for (Method method : methods) {
//                String methodName = method.getName();
//                System.out.println("方法名称:" + methodName);
//                Class<?>[] parameterTypes = method.getParameterTypes();
//                for (Class<?> clas : parameterTypes) {
//                    String parameterName = clas.getName();
//                    System.out.println("参数名称:" + parameterName);
//                }
//                System.out.println("*****************************");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//            // threadLocal.set("main");
//
//            Main test = new Main();
//            test.start();//在子线程中获取
//
//            //在主线程中获取
//            String result = threadLocal.get();
//            System.out.println("main thread get str" + result);

//        double yuan  =  189899;
//        double yuan  =  189833;

        double[] yuans = {189999, 189899, 189833, 78999, 69000, 69190, 12123, 9999, 9890, 9880, 9000, 8787, 10000, 34567};

        for (int i = 0; i < yuans.length; i++) {
            System.out.println(yuan2wan(yuans[i]));
        }


    }

    public static double yuan2wan(double yuan) {
//        return ((int) (yuan / 100))/100.0;
        return divide((int) divide(yuan, 100.00, 0), 100.00, 2);
    }


    public static double divide(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static String divide1(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        BigDecimal dd = b1.divide(b2);
        return formatDouble3(dd.doubleValue());
//        return b1.divide(b2, scale, BigDecimal.ROUND_UP).doubleValue();
    }


    public static String formatDouble3(double d) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        // 保留两位小数
        nf.setMaximumFractionDigits(0);

        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.UP);
        return nf.format(d);
    }


    @Override
    public void run() {
//        threadLocal.set("123123");
//        threadLocal.set("123123");
//        String result = threadLocal.get();
//
//        System.out.println("ThreadLocalTest thread get str" + result);
    }


    public static void listDir(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                listDir(f);
            }
        } else {
            if (isRealPage(file.getName()) && file.toString().contains(parentFile.toString())) {
                String str = file.toString().replace(parentFile.toString() + File.separator, "");
                System.out.println(str.replace(File.separator, ".").replace(".class", ""));
            }
        }
    }


    public static boolean isRealPage(String fileName) {
        if (fileName == null || fileName.length() == 0) {
            return false;
        }
        if (fileName.startsWith("R") || fileName.contains("$$ViewBinder") || fileName.contains("Cst")) {
            return false;
        }
        return true;
    }


}
