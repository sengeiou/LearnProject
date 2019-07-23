# ThreadLocal 解析

> 需要的知识点
* java 引用
* java 集合
* java 线程
* java hash

> 延伸问题
* 线程间的通信
* Android 的 Looper Handler 中的 ThreadLocal 


####首先看下什么是ThreadLocal


> This class provides thread-local variables. These variables differ from their normal counterparts in that each thread that accesses one (via its get or set method) has its own, independently initialized copy of the variable. ThreadLocal instances are typically private static fields in classes that wish to associate state with a thread (e.g., a user ID or Transaction ID).

> 这个类提供了线程的局部变量，这些变量在不同的线程访问时，都能获取每个线程独有的变量副本，ThreadLocal 一般是一个私有静态变量。。。。。



*  来看下ThreadLocal的 用法

```
public class ThreadLocalTest extends Thread {

	public static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {

		@Override
		protected String initialValue() {
			// 设置初始值，这里使用当前thread的名字
			return Thread.currentThread().getName();
		}

	};

	public static void main(String[] args) {
		// threadLocal.set("main");

		ThreadLocalTest test = new ThreadLocalTest();
		test.start();//在子线程中获取

		//在主线程中获取
		String result = threadLocal.get();
		System.out.println("main thread get str" + result);

		//这个例子从子线程和主线程去访问ThreadLocal, 但是他们get()到的结果却是不同的

	}

	public void run() {
		String result = threadLocal.get();
		System.out.println("ThreadLocalTest thread get str" + result);
	}
}

```

1. ThreadLocal是java.lang包下的一个类, 支持泛型
2. 在初始化ThreadLocal时可以重写initialValue在设置它的初始值
3. 用set方法存储，用get方法获取

> 总的来说，ThreadLocal的使用还是很简单的




```
  // 返回这个ThreadLocal的初始值，可以由子类重写
  // 当一个线程第一次调用get()方法并且之前没有调用set方法，initialValue方法将被执行，具体可以看get方法setInitialValue
  protected T initialValue() {
        return null;
  }

  
	
  public T get() {
       Thread t = Thread.currentThread();
       ThreadLocalMap map = getMap(t);
       if (map != null) { 
            ThreadLocalMap.Entry e = map.getEntry(this);
            if (e != null) {  
                @SuppressWarnings("unchecked")
                T result = (T)e.value;
                return result;     //掉用过过set方法后，取出ThreadLocalMap的值返回
            }
        }
        // map为null，说明ThradLocal之前没有被任何线程掉用过
        //  e 为null，说明当前线程没有存储过任何值
        return setInitialValue();  
   }


	//获取初始值的value，并将这个value 存储到ThreadLocalMap中
    private T setInitialValue() {
        T value = initialValue();
        Thread t = Thread.currentThread();
        //线程中都有一个ThreadLocal.ThreadLocalMap变量，
        // 这个map的key是ThreadLocal value是你存储的值
        ThreadLocalMap map = getMap(t);  
        if (map != null)
            map.set(this, value); 
        else
            createMap(t, value);
        return value;   
    }



	//一开始很不理解，为什么创建一个ThreadLocalMap来维护存储的变量, 不能直接用一个Object变量来做存储吗？
	//其实是思维固化在多线程访问单一的ThreadLocal，当线程访问多个ThreadLocal的时候，ThreadLocalMap就是必要的了，毕竟map中的key是用ThreadLocal的
	//
	/**
	*  获取Thread 中的ThreadLocalMap
	*
    */
    ThreadLocalMap getMap(Thread t) {
        return t.threadLocals;
    }
    /**
	*  创建Thread 中的ThreadLocalMap
	*
    */
    void createMap(Thread t, T firstValue) {
        t.threadLocals = new ThreadLocalMap(this, firstValue);
    }


    /**
	*  清除当前线程的保存在ThreadLocal 的变量
	*  	
    */
    public void remove() {
         ThreadLocalMap m = getMap(Thread.currentThread());
         if (m != null)
             m.remove(this);
    }



    // ThreadLocal 的静态内部类,暂时不做过多的分析

	static class ThreadLocalMap {

	static class Entry extends WeakReference<ThreadLocal<?>> {
            /** The value associated with this ThreadLocal. */
            Object value;

            Entry(ThreadLocal<?> k, Object v) {
                super(k);
                value = v;
            }
        }

	}	


```
