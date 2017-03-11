# 观察者模式

###  demo1 主要写了怎么让李斯监控韩非子, 用线程的while(true) 去实现
      
     这样的代码虽然起到了监控的作用，但是在线程中使用了 while(true) ，非常消耗系统的资源
     

### demo2 中将对代码进行修改，去掉了spy的间谍类，通过聚集方式，将观察者直接放到了被观察者对象中

	demo2 中虽然解决了demo1的问题，但是，还是发现了一些问题

	1. 观察者应该是多个，而不是一个，观察者应该是一个抽象


### demo3 中，对代码进行修改，主要做了下面几点

	1. 增加Observable（被观察者） 接口， 定义了对观察者操作的方法
	2. 增加 Observer  （观察者） 接口

	好处是实现了类之间的解耦，如果想要增加观察者，那么只要去实现 Observer 的接口 就行


### 通过上面的三个demo，主要讲了下观察者模式的实现
	（定义对象间一对多的依赖关系，使得当一个对象改变状态，则所有依赖它的对象都会得到通知并被自动更新 ）
	* Subject （被观察者）一般是接口或实现类 最主要是作用， 管理观察者并通知观察者
	* Observer （观察者） 一般是接口， 收到通知后，进行 update
	* ConcrestSubject (具体的被观察者)  定义哪些事件被通知
	* ConcrestObserver （具体的观察者） 定义收到事件后的实现



### jdk 也对观察者模式进行了封装
   先来看下 java.util.Observable  基于7u40-b43 

```
public class More ...Observable {
	// 是一个表示符，如果是true 则会通知所有的观察者，所以被观察者的监听事件中要调用此方法，不然无法通知到观察者
     private boolean changed = false;
     //不同于我们自己实现的ArrayList ，vectors 基于线程安全的，ArrayList则不是
     private Vector obs;

     public Observable() {
         obs = new Vector();
     }

 	 //增加观察者，观察者去重
     public synchronized void addObserver(Observer o) {
         if (o == null)
             throw new NullPointerException();
         if (!obs.contains(o)) {
             obs.addElement(o);
         }
     }

     public synchronized void deleteObserver(Observer o) {
       obs.removeElement(o);
      }

    public void notifyObservers(Object arg) {
        /*
         * a temporary array buffer, used as a snapshot of the state of
         * current Observers.
         */
        Object[] arrLocal;
		// 这个比较不理解
        synchronized (this) {
            /* We don't want the Observer doing callbacks into
             * arbitrary code while holding its own Monitor.
             * The code where we extract each Observable from
             * the Vector and store the state of the Observer
             * needs synchronization, but notifying observers
             * does not (should not).  The worst result of any
             * potential race-condition here is that:
             * 1) a newly-added Observer will miss a
             *   notification in progress
             * 2) a recently unregistered Observer will be
             *   wrongly notified when it doesn't care
             */
            if (!changed)
                return;
            arrLocal = obs.toArray();
            clearChanged(); // 清除标识符
        }

        for (int i = arrLocal.length-1; i>=0; i--)
        	// 还没用泛型？
            ((Observer)arrLocal[i]).update(this, arg);
    }

    protected synchronized void clearChanged() {
        changed = false;
    }


	// Observer 则比较简单，就是定义了一个方法
	public interface Observer {

    void update(Observable o, Object arg);
    
    }


```


### 根据上面的源码，我们来写个demo4 , 看起来简洁多了。


### 观察者模式的缺点
	1. 一个被观察者，多个观察者，因为java中代码是顺序执行的，只要一个观察者出错，那么就会影响整体
	2. 多级触发的问题，一个观察者可以是观察者，同事也可以是被观察者，如果一旦这么写了，程序的逻辑就会非常混乱，在实际开发中，最多只能出现一个这样的双重身份的类。

	


