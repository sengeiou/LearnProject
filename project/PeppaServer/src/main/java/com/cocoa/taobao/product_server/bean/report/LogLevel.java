package com.cocoa.taobao.product_server.bean.report;

public class LogLevel {

    // log4j log levels.
    public final static LogLevel FATAL = new LogLevel("FATAL", 0);
    public final static LogLevel ERROR = new LogLevel("ERROR", 1);
    public final static LogLevel WARN = new LogLevel("WARN", 2);
    public final static LogLevel INFO = new LogLevel("INFO", 3);
    public final static LogLevel DEBUG = new LogLevel("DEBUG", 4);


    public static LogLevel create(String msg) {
        if (msg.equalsIgnoreCase(LogLevel.DEBUG.msg)) {
            return LogLevel.DEBUG;
        } else if (msg.equalsIgnoreCase(LogLevel.INFO.msg)) {
            return LogLevel.INFO;
        } else if (msg.equalsIgnoreCase(LogLevel.WARN.msg)) {
            return LogLevel.WARN;
        } else if (msg.equalsIgnoreCase(LogLevel.ERROR.msg)) {
            return LogLevel.ERROR;
        } else if (msg.equalsIgnoreCase(LogLevel.FATAL.msg)) {
            return LogLevel.FATAL;
        }
        return null;
    }

    private String msg;
    private int code;

    public LogLevel(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
