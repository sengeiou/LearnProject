package com.cocoa.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by sj on 17/2/8.
 */
public class Main {

    public static  void main(String[] args){

        Observable  o  = Observable.create(new ObservableOnSubscribe() {
            public void subscribe(ObservableEmitter e) throws Exception {

            }
        });


    }

}
