package com.cocoa.t_rxjava.oper;

import android.os.Bundle;
import android.widget.TextView;

import com.cocoa.t_rxjava.Person;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;


/**
 * Created by junshen on 2018/1/2.
 */

public class TranActivity extends BaseActivity {

    public static final String TAG = "MainActivity";
    private TextView tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    void flatmap2 (){
        Person[] p = new Person[2];
        Person p1  = new Person();
        p1.name =  "p1";
        p1.books = new ArrayList<>();
        p1.books.add("book11");
        p1.books.add("book22");
        p1.books.add("book33");

        Person p2  = new Person();
        p2.name =  "p2";
        p2.books = new ArrayList<>();
        p2.books.add("book1");
        p2.books.add("book2");
        p2.books.add("book3");

        p[0] = p1;
        p[1] = p2;

        ObservableOnSubscribe<String> observableOnSubscribe = new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("1");
                e.onNext("2");
                e.onNext("3");
                e.onNext("4");
                e.onComplete();
            }
        };
        Observable.create(observableOnSubscribe).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                e.onNext("");
            }
        }, BackpressureStrategy.ERROR).subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(1);
            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });

    }




    // buffer(bufferClosingSelector)
    void flatMap() {
        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                for (int i = 0; i < 30; i++) {
                    Thread.sleep(500);
                    e.onNext(String.valueOf(i));
                }
            }
        }).flatMap(new Function<String, ObservableSource<Map<String, String>>>() {
            @Override
            public ObservableSource<Map<String, String>> apply(final String s) throws Exception {
                return new Observable<Map<String, String>>() {
                    @Override
                    protected void subscribeActual(Observer<? super Map<String, String>> observer) {
                        int sInt = Integer.parseInt(s);
                        HashMap<String, String> map = new HashMap<>();
                        if (sInt % 10 == 0) {
                            map.put(s, s);
                        }

                        observer.onNext(map);

                    }
                };
            }
        }).subscribe(new Observer<Map<String, String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Map<String, String> stringStringMap) {
                printMsg(stringStringMap.size() + "");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }


    // buffer(bufferClosingSelector)
    void buffer2() {
        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                for (int i = 0; i < 30; i++) {
                    Thread.sleep(500);
                    e.onNext(String.valueOf(i));
                }
            }
        }).buffer(5).subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<String> strings) {
                printMsg(strings.size() + "");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                printMsg("complete");
            }
        });
    }

    /**
     * 每隔半秒发送一次数据，只有在发送的数据满五条后，观察者才能收到
     */
    void buffer1() {
        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                for (int i = 0; i < 30; i++) {
                    Thread.sleep(500);
                    e.onNext(String.valueOf(i));
                }
            }
        }).buffer(5).subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<String> strings) {
                printMsg(strings.size() + "");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                printMsg("complete");
            }
        });


    }


}
