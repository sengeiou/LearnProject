package com.cocoa;

public class TestChild {

    private  String addr;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "TestChild{" +
                "addr='" + addr + '\'' +
                '}';
    }
}
