# Sending Operations to Multiple Threads (Handler,Looper,Thread)

> 本文是对官方文档 [Sending Operations to Multiple Threads](https://developer.android.com/training/multiple-threads/index.html)的翻译, 其中加入了自己的理解和源码分析

### Specifying the Code to Run on a Thread 使用线程
 * 这个章节会教我们怎么实现runnable 接口, 然后再单独的线程中去执行run() 方法中的代码,你可以传递一个Runnable 到另一个对象, 然后加载到线程上去执行,一个或多个
Runnable对象完成一些特定的操作通常被称为任务。

 * Thread 和 Runnable 都是一些基础的类, 有他们的局限性, 代替他们的是一些android 类, 比如HandlerThread, AsyncTask, and IntentService, 
Thread 和 Runnable也是ThreadPoolExecutor的基础, 这个类自动管理了线程和任务队列, 甚至可以同时运行多线程.


 * 定义类去实现Runnable 接口

> 不解释了, 太基础了
```
public class PhotoDecodeRunnable implements Runnable {
    ...
    @Override
    public void run() {
        /*
         * Code you want to run on the thread goes here
         */
        ...
    }
    ...
}
```

 * Implement the run() Method   实现run方法

 * 在实现了runnable 的类中 ,run方法中包含了需要执行的代码, 通常来说, 任何代码都可以放在run方法中, 记住, runnable 不能执行在UI 线程, 所以也不能直接修改UI, 比如view对象,
在下面的内容中,会讲到怎么和UI 交互。







### Looper代码查看 

>下面是官方文档的一个demo

```
Class used to run a message loop for a thread. Threads by default do not have a message loop associated with them; 
to create one, call prepare() in the thread that is to run the loop, and then loop() to have it process messages until the loop is stopped.
Most interaction with a message loop is through the Handler class.
This is a typical example of the implementation of a Looper thread, 
using the separation of prepare() and loop() to create an initial Handler to communicate with the Looper.

  class LooperThread extends Thread {
      public Handler mHandler;

      public void run() {
          Looper.prepare();

          mHandler = new Handler() {
              public void handleMessage(Message msg) {
                  // process incoming messages here
              }
          };

          Looper.loop();
      }
  }

```



