package com.cocoa.rmq_client.util;

public class TextUtil {
    public static boolean isEmpty(String msg) {
        return msg == null || "".equals(msg);
    }
}
