package com.cocoa.shiji.util;

public class NullUtil {

    public static void isNull(Object o, String msg) {
        if (o == null) {
            throw new NullPointerException(msg);
        }
        if (o instanceof String) {
            isNull((String) o, msg);
        }
    }

    public static void isNull(String o, String msg) {
        if (TextUtil.isEmpty(o)) {
            throw new NullPointerException(msg);
        }
    }
}
