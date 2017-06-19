package com.cocoa.nio;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cocoa on 2017/6/14.
 */
public class NioClient extends Main {

    public static void main(String[] args) {
//        try {
//            Socket socket = new Socket(ADDRESS, PORT);
//            OutputStream outputStream = socket.getOutputStream();
//            OutputStreamWriter bufferedOutputStream = new OutputStreamWriter(outputStream);
//            bufferedOutputStream.write("Hello nio server");
//            bufferedOutputStream.close();
//            outputStream.close();
//            socket.close();
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }


        String ss = ("ashdashjdajhj\n17682342410知道的123");

        System.out.println(ss.split("\\n").length);

    }

    /**
     * 检测字符串中含有手机号，手机号检测只检测是否是1开头（类似taobao）
     * @param num
     * @return
     */
    public static boolean havePhoneNum(String num) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(num);
        while (matcher.find()) {
            String numStr = matcher.group(0);
            if (numStr.length() == 11 && numStr.startsWith("1")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 包含三个数字
     * @param num
     * @return
     */
    public static boolean haveThreeNum(String num) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(num);
        while (matcher.find()) {
            String numStr = matcher.group(0);
            if (numStr.length() == 3) {
                return true;
            }
        }
        return false;
    }

}
