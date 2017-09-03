package com.cocoa.rxjava;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * RxJava 2.0有什么不同(译)
 * http://blog.csdn.net/qq_35064774/article/details/53045298?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
 *
 * https://www.slideshare.net/ssuser72c3b0/rxjava-20
 *
 * Created by sj on 17/5/17.
 * 参考：https://github.com/ReactiveX/RxJava
 * http://www.jianshu.com/p/464fa025229e
 * https://zouzhberk.github.io/rxjava-study/?hmsr=toutiao.io&utm_medium=toutiao.io
 *
 * Lesson1
 * Observable 被观察者
 * Observer  观察者
 * Observable 需要用 subscribe  去订阅观察者
 * 1。无论是 观察者还是被观察者 都是在主线程中去执行的
 * 2。当被观察者发出 onError 的事件后， 后面的事件将不会被接收
 *
 *
 *
 * ObservableEmitter 实现了Emitter 接口，有了三个发送事件的方法  onNext onError onComplete
 *
 * 关于发送的事件
 * 上游可以发送无限个onNext, 下游也可以接收无限个onNext.
 * 当上游发送了一个onComplete后, 上游onComplete之后的事件将会继续发送, 而下游收到onComplete事件之后将不再继续接收事件.
 * 当上游发送了一个onError后, 上游onError之后的事件将继续发送, 而下游收到onError事件之后将不再继续接收事件.
 * 被观察者可以不发送 onError 和 onComplete
 * 最为关键的是onComplete和onError必须唯一并且互斥, 即不能发多个onComplete, 也不能发多个onError, 也不能先发一个onComplete, 然后再发一个onError, 反之亦然
 *
 *
 * 接下来介绍Disposable, 取消订阅。 这个单词的字面意思是一次性用品,用完即可丢弃的. 那么在RxJava中怎么去理解它呢,
 * 对应于上面的水管的例子, 我们可以把它理解成两根管道之间的一个机关, 当调用它的dispose()方法时,
 * 它就会将两根管道切断, 从而导致下游收不到事件. （但是被观察者还是会继续发送事件，只是观察者不接收了）
 *
 *
 */
public class Test1 {

    static  Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(ObservableEmitter<String> e) throws Exception {

            System.out.println("ovservable subscript "+ Thread.currentThread().getName());

            e.onNext("1");
            e.onNext("2");
            e.onNext("3");
            e.onError(new Throwable("123"));
            e.onComplete();
        }
    });

    static  Observer observer = new Observer() {

        Disposable  disposable;

        @Override
        public void onSubscribe(Disposable d) {
            disposable = d;
        }

        @Override
        public void onNext(Object o) {
            System.out.println("observer onnext "+ Thread.currentThread().getName());
            System.out.println(o);
//            disposable.dispose();
        }

        @Override
        public void onError(Throwable e) {
            System.out.println("onError");
            System.out.println(e);
        }

        @Override
        public void onComplete() {
            System.out.println("observer onComplete "+ Thread.currentThread().getName());
            System.out.println("onComplete");
        }
    };

    public static void main(String[] args ){
        observable.subscribe(observer);
    }
}
