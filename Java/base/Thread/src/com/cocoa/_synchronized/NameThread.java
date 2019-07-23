package com.cocoa._synchronized;

/**
 * Created by Administrator on 2016/7/1.
 */
public class NameThread extends  Thread {

    private Person p ;

    public NameThread(Person p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
        super.run();
        p.changeName(getName());
    }
}
