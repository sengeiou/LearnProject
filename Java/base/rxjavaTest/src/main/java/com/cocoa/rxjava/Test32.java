package com.cocoa.rxjava;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sj on 17/8/22.
 */
public class Test32 {

    public static void main(String[] args) {

        // create source
        Observable<String> observer0 = Observable.fromArray("1", "2", "3", "123").filter(new Predicate<String>() {
                                                                                             @Override
                                                                                             public boolean test(String s) throws Exception {
                                                                                                 System.out.println(Thread.currentThread().getName());
                                                                                                 return s.startsWith("1");
                                                                                             }
                                                                                         }
        ).subscribeOn(Schedulers.newThread());
        ;

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("" + i);
        }
        Observable<String> observer1 = Observable.fromIterable(list).filter(new Predicate<String>() {
                                                                                @Override
                                                                                public boolean test(String s) throws Exception {
                                                                                    return s.startsWith("1");
                                                                                }
                                                                            }
        )
//                .subscribeOn(Schedulers.newThread());
        ;

        Observable<String> observer3 = Observable.just("1");
        Maybe maybe = Maybe.just("1");

        Flowable flowable = Flowable.fromCallable(() -> "123");


        System.out.println(Thread.currentThread().getName());
        System.out.println("main thead start other");
        observer1.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println(d);
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);

            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e);

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");

            }
        });




    }


}
