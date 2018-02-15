package com.cocoa.rxjava.rxjava.oper;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by junshen on 2018/1/2.
 */

public class CreateActivity extends BaseActivity {

    public static String[] oper = {"create", "defer", "333", "222", "222", "222", "222"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clearAddNewItems(oper);
    }

    public void create() {

        appendContent("在这个例子中，我们只看 Observable.create ");
        appendContent(" Observable.create 方法默认不再任何特定的调度器上执行");
        appendContent(" Observable.create 方法 创建了一个Observable 对象，然后再subscribe 方法中每个0.5秒调用 onNext方法");
        appendContent("注意 onNext onError onComplete 这三个方法");
        appendContent("onNext 可以被多次调用， onError onComplete 只能被调用一次");
        appendContent("打开程序中注释掉的三行代码，这是故意测试调用 onError的例子，发现只要一调用 onError, onComplete将不会被执行");


        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(500);
                        e.onNext(String.valueOf(i));
//                        if(i == 5) {
//                            int a = i /0 ;
//                        }
                    }
                } catch (Exception ex) {
                    e.onError(ex);
                }
                e.onComplete();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        appendTitle(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        appendTitle(e.getLocalizedMessage());
                        appendTitle(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appendTitle("onComplete");

                    }
                });

    }

    public void defer(){
        Observable.defer(new Callable<ObservableSource<String>>() {
            @Override
            public ObservableSource<String> call() throws Exception {
                Log.e(TAG,"start create observableSource");
                return new ObservableSource<String>() {
                    @Override
                    public void subscribe(Observer<? super String> observer) {
                            observer.onNext("1");
                    }
                };
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        appendTitle(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        appendTitle(e.getLocalizedMessage());
                        appendTitle(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        appendTitle("onComplete");

                    }
                });
    }

}
