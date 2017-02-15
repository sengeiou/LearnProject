package com.cocoa.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import java.nio.channels.SelectionKey;

/**
 * Created by sj on 17/2/8.
 */
public class Main {

    public static void main(String[] args) {

        int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE | SelectionKey.OP_CONNECT;
//        Observable  o  = Observable.create(new ObservableOnSubscribe() {
//            public void subscribe(ObservableEmitter e) throws Exception {
//
//            }
//        });

        System.out.println(interestSet);
    }

}
