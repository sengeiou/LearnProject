package com.cocoa.rxjava;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sj on 17/5/17.
 *
 *
 * Lesson2
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class Test2 {
    public static void main(String[] args) {

        String[] str = {"shen","jun"};
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(123);
                e.onNext(223);
                System.out.println(Thread.currentThread().getName());
            }
        }).subscribeOn(Schedulers.newThread()).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return integer+"----";
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("===="+Thread.currentThread().getName());
                System.out.println(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });






    }
}
