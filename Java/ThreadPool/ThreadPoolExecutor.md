### ThreadPoolExecutor
----------
> 首先来看下 ThreadPoolExecutor 的 API 文档，这个文档里写了很多知识点，http://docs.oracle.com/javase/8/docs/api/

```
public class ThreadPoolExecutor
extends AbstractExecutorService

An ExecutorService that executes each submitted task using one of possibly several pooled threads, normally configured using Executors factory methods.
// 一个 ExecutorService 可以执行每个提交到池中的线程，一般使用 Executors 中的工厂方法去配置

Thread pools address two different problems: they usually provide improved performance when executing large numbers of asynchronous tasks, due to reduced per-task invocation overhead, and they provide a means of bounding and managing the resources, including threads, consumed when executing a collection of tasks. Each ThreadPoolExecutor also maintains some basic statistics, such as the number of completed tasks.
// 线程池解决两个不同的问题：当执行大量异步任务时，就需要去改善提高效率（线程用于在需要执行大量异步任务的情况下），由于每个任务调用开销减少，他们提供了一个管理资源的办法，包括线程，执行一个队列任务的消费，每个 ThreadPoolExecutor 都会对已经完成的线程进行统计。


To be useful across a wide range of contexts, this class provides many adjustable parameters and extensibility hooks. However, programmers are urged to use the more convenient Executors factory methods Executors.newCachedThreadPool() (unbounded thread pool, with automatic thread reclamation), Executors.newFixedThreadPool(int) (fixed size thread pool) and Executors.newSingleThreadExecutor() (single background thread), that preconfigure settings for the most common usage scenarios. Otherwise, use the following guide when manually configuring and tuning this class:
// 为了在广泛的上下文中使用，这个类提供了灵活的参数和可扩展的hooks，推荐程序员使用 Executors 中的工厂方法去调用，这个方法预先设置了很多通用场景，另外，你也可以阅读下面的手册，去手动配置调用这个类
//1. Executors.newCachedThreadPool(无限制的线程池,自动回收线程)
//2. Executors.newFixedThreadPool(int) (固定大小的线程池)
//3. Executors.newSingleThreadExecutor() (单后台线程)  

Core and maximum pool sizes
// 核心和最大的线程数
A ThreadPoolExecutor will automatically adjust the pool size (see getPoolSize()) according to the bounds set by corePoolSize (see getCorePoolSize()) and maximumPoolSize (see getMaximumPoolSize()). When a new task is submitted in method execute(Runnable), and fewer than corePoolSize threads are running, a new thread is created to handle the request, even if other worker threads are idle. If there are more than corePoolSize but less than maximumPoolSize threads running, a new thread will be created only if the queue is full. By setting corePoolSize and maximumPoolSize the same, you create a fixed-size thread pool. By setting maximumPoolSize to an essentially unbounded value such as Integer.MAX_VALUE, you allow the pool to accommodate an arbitrary number of concurrent tasks. Most typically, core and maximum pool sizes are set only upon construction, but they may also be changed dynamically using setCorePoolSize(int) and setMaximumPoolSize(int).
// ThreadPoolExecutor 会根据 corePoolSize 和 maximumPoolSize 去调整池中的线程数，当一个新的任务提交到方法执行时，如果小于 corePoolSize 的线程在执行，即线程池中有空闲的线程，会创建的新的线程去处理请求。如果运行的线程数大于 corePoolSize 并且 小于 maximumPoolSize，只要队列满了，就会创建新的线程。如果 corePoolSize 和 maximumPoolSize 是一样的，那么就是创建了固定的线程池， 如果设置 maximumPoolSize 不限制，比如 Integer.MAX_VALUE ，那么就是允许线程池容纳任意数量的并发任务，最典型的，核心和最大的线程数在构造方法中创建，但是也可以使用 setCorePoolSize(int) 和 setMaximumPoolSize(int) 方法去动态的改变。

On-demand construction
By default, even core threads are initially created and started only when new tasks arrive, but this can be overridden dynamically using method prestartCoreThread() or prestartAllCoreThreads(). You probably want to prestart threads if you construct the pool with a non-empty queue.
// 默认情况下，当新的任务到达的时候，线程才会被创建和使用，但是可以用  prestartCoreThread() or prestartAllCoreThreads() 去动态的重写，你也许会想要在创建一个非空的队列的线程池的时候去预启动线程

Creating new threads
New threads are created using a ThreadFactory. If not otherwise specified, a Executors.defaultThreadFactory() is used, that creates threads to all be in the same ThreadGroup and with the same NORM_PRIORITY priority and non-daemon status. By supplying a different ThreadFactory, you can alter the thread's name, thread group, priority, daemon status, etc. If a ThreadFactory fails to create a thread when asked by returning null from newThread, the executor will continue, but might not be able to execute any tasks. Threads should possess the "modifyThread" RuntimePermission. If worker threads or other threads using the pool do not possess this permission, service may be degraded: configuration changes may not take effect in a timely manner, and a shutdown pool may remain in a state in which termination is possible but not completed.
// 使用 ThreadFactory 去创建一个新的线程，如果没有特殊的指定，会调用 Executors.defaultThreadFactory() ，这样创建的线程会在线程组，并且他们的优先级都是NORM_PRIORITY，并且都是非守护状态，通过不同的 ThreadFactory， 你可以去修改线程的名字，线程的 group, 优先级，守护状态等等，当创建线程失败时，这个 executor 会继续，可能会不执行任何的任务. 线程需要掌控 "modifyThread" 运行时权限，如果工作线程或者线程池中的线程不能掌控这个权限，服务就会降级，configuration changes may not take effect in a timely manner, and a shutdown pool may remain in a state in which termination is possible but not completed.


Keep-alive times
If the pool currently has more than corePoolSize threads, excess threads will be terminated if they have been idle for more than the keepAliveTime (see getKeepAliveTime(TimeUnit)). This provides a means of reducing resource consumption when the pool is not being actively used. If the pool becomes more active later, new threads will be constructed. This parameter can also be changed dynamically using method setKeepAliveTime(long, TimeUnit). Using a value of Long.MAX_VALUE TimeUnit.NANOSECONDS effectively disables idle threads from ever terminating prior to shut down. By default, the keep-alive policy applies only when there are more than corePoolSize threads. But method allowCoreThreadTimeOut(boolean) can be used to apply this time-out policy to core threads as well, so long as the keepAliveTime value is non-zero.
// 如果池中有超过 corePoolSize 的线程， 如果他们空闲的时间超过 keepAliveTime 则会被中止。 当线程池没有被充分利用的情况下，这样是一种可以减少资源的消耗的方式，如果线程池变的很活跃，那么新的线程就会被创建。使用 setKeepAliveTime 可以动态的修改这个参数，使用 Long.MAX_VALUE TimeUnit.NANOSECONDS 可以有效的确保空闲线程不会被关闭，默认情况下，只有在线程数超过 corePoolSize 时，keep-alive 参数才会生效,
allowCoreThreadTimeOut(boolean) 可以用来设置还没超过线程数超过 corePoolSize 时的线程的 keepAliveTime。 


Queuing
Any BlockingQueue may be used to transfer and hold submitted tasks. The use of this queue interacts with pool sizing:
-If fewer than corePoolSize threads are running, the Executor always prefers adding a new thread rather than queuing.
-If corePoolSize or more threads are running, the Executor always prefers queuing a request rather than adding a new thread.
-If a request cannot be queued, a new thread is created unless this would exceed maximumPoolSize, in which case, the task will be rejected.
// 任何 BlockingQueue 可以用用来传递和保存提交的任务，这个队列和线程池大小是相互关联的：
// 如果小于 corePoolSize 的线程在运行，执行器通常会增加一个新的线程，而不是排队（让任务进入队列），如果当前运行的线程数达到或超过 corePoolSize ，执行器往往会把任务加入到队列而不是创建新的线程，
//如果一个任务不能加入队列，并且不超过 maximumPoolSize，就会创建一个新的线程，在这种情况下（超过maximumPoolSize），这个任务会被驳回。

There are three general strategies for queuing:
// 这里有3种策略的队列
Direct handoffs. A good default choice for a work queue is a SynchronousQueue that hands off tasks to threads without otherwise holding them. Here, an attempt to queue a task will fail if no threads are immediately available to run it, so a new thread will be constructed. This policy avoids lockups when handling sets of requests that might have internal dependencies. Direct handoffs generally require unbounded maximumPoolSizes to avoid rejection of new submitted tasks. This in turn admits the possibility of unbounded thread growth when commands continue to arrive on average faster than they can be processed.
// 直接传递。如果想要不干涉任务的线程，并不持有他们，默认的好的选择就是使用 SynchronousQueue 。 这里， 如果没有立即可用的线程去执行，那么队列的任务就会失败，所以一个新的线程就会被创建。当处理大量的有内部关联的请求时，这个策略就可以避免锁。Direct handoffs 一般需要无界的 maximumPoolSizes 去避免拒绝新提交的任务，这反过来承认，当命令继续平均到达速度比处理速度快时，可能会出现无限线程增长的可能性。

Unbounded queues. Using an unbounded queue (for example a LinkedBlockingQueue without a predefined capacity) will cause new tasks to wait in the queue when all corePoolSize threads are busy. Thus, no more than corePoolSize threads will ever be created. (And the value of the maximumPoolSize therefore doesn't have any effect.) This may be appropriate when each task is completely independent of others, so tasks cannot affect each others execution; for example, in a web page server. While this style of queuing can be useful in smoothing out transient bursts of requests, it admits the possibility of unbounded work queue growth when commands continue to arrive on average faster than they can be processed.
// 无界队列. 使用无界队列（ 比如LinkedBlockingQueue 就没有预先定义容量 ）将对导致任务在队列中等待，当所有的 corePoolSize 线程繁忙. 因此，不再有比 corePoolSize  的线程去创建，（因此 maximumPoolSize 的值不会有任何影响 ），每个线程间相互独立，所以任务间也不会相互影响，举个例子，在web服务端，在平滑的请求增加时，这样的队列策略就显得很有用，同时在任务提交数量平均速度大于线程池可以处理的速度时，可以使无限的任务继续提交。 

Bounded queues. A bounded queue (for example, an ArrayBlockingQueue) helps prevent resource exhaustion when used with finite maximumPoolSizes, but can be more difficult to tune and control. Queue sizes and maximum pool sizes may be traded off for each other: Using large queues and small pools minimizes CPU usage, OS resources, and context-switching overhead, but can lead to artificially low throughput. If tasks frequently block (for example if they are I/O bound), a system may be able to schedule time for more threads than you otherwise allow. Use of small queues generally requires larger pool sizes, which keeps CPUs busier but may encounter unacceptable scheduling overhead, which also decreases throughput.
// 有界队列，有界队列可以在有限的 maximumPoolSizes 时防止资源枯竭（ArrayBlockingQueue），但是会比较难的去调整和控制，队列的大小和 maximum pool 的大小可能会此消彼长（相互影响），使用大的队列，小的线程池会降低CPU 的使用率，系统资源，上下文切换的开销，但是可以降低吞吐量； 如果任务频繁的阻塞（比如I/O bound），系统就会去安排更多的线程，超过你允许的，使用小队列通常需要大的线程池，会增加 CPU的资源，调度成本，造成吞吐量降低。
// 这一段大致的意思是，队列大小 和 maximumPoolSizes ，谁高谁低一定要分配好，不然都会造成吞吐量降低

Rejected tasks
New tasks submitted in method execute(Runnable) will be rejected when the Executor has been shut down, and also when the Executor uses finite bounds for both maximum threads and work queue capacity, and is saturated. In either case, the execute method invokes the RejectedExecutionHandler.rejectedExecution(Runnable, ThreadPoolExecutor) method of its RejectedExecutionHandler. 
Four predefined handler policies are provided:
// 当 Executor 关闭后，一个新添加的任务（execute(Runnable)） 就会被拒绝，同样的情况也会出现在 Executor 使用了最大的线程数和最大的队列数 （两者都饱和了），不管哪种情况，执行器就会去调用 RejectedExecutionHandler.rejectedExecution(Runnable, ThreadPoolExecutor)  ,这里提供了4个预定义的 handler 策略

-In the default ThreadPoolExecutor.AbortPolicy, the handler throws a runtime RejectedExecutionException upon rejection.
// ThreadPoolExecutor.AbortPolicy ，拒绝任务时，抛出RejectedExecutionException

-In ThreadPoolExecutor.CallerRunsPolicy, the thread that invokes execute itself runs the task. This provides a simple feedback control mechanism that will slow down the rate that new tasks are submitted.
// ThreadPoolExecutor.CallerRunsPolicy ，调用线程会执行该任务，这个策略提供了一个反馈机制去减慢新任务的提交

-In ThreadPoolExecutor.DiscardPolicy, a task that cannot be executed is simply dropped.
// 任务不能被执行，放弃。

-In ThreadPoolExecutor.DiscardOldestPolicy, if the executor is not shut down, the task at the head of the work queue is dropped, and then execution is retried (which can fail again, causing this to be repeated.)
// 如果执行器没有关闭，工作队列头的任务将会被丢弃，然后执行器重新 
 尝试执行任务（如果失败，则重复这一过程） 

It is possible to define and use other kinds of RejectedExecutionHandler classes. Doing so requires some care especially when policies are designed to work only under particular capacity or queuing policies.
// 我们也可以自己定义RejectedExecutionHandler，以适应特殊的容量和队列策略场景中。 

Hook methods
This class provides protected overridable beforeExecute(Thread, Runnable) and afterExecute(Runnable, Throwable) methods that are called before and after execution of each task. These can be used to manipulate the execution environment; for example, reinitializing ThreadLocals, gathering statistics, or adding log entries. Additionally, method terminated() can be overridden to perform any special processing that needs to be done once the Executor has fully terminated.
// 这个类提供了受保护和可覆盖的 beforeExecute(Thread, Runnable) and afterExecute(Runnable, Throwable)  可以在执行任务前后调用，这样就可以去操控执行的环境。

If hook or callback methods throw exceptions, internal worker threads may in turn fail and abruptly terminate.
// 如果钩子和回调方法抛出异常，内部的工作线程会失败并且终止!

Queue maintenance
//队列维护
Method getQueue() allows access to the work queue for purposes of monitoring and debugging. Use of this method for any other purpose is strongly discouraged. Two supplied methods, remove(Runnable) and purge() are available to assist in storage reclamation when large numbers of queued tasks become cancelled.
// 方法 getQueue() 允许访问工作队列，达到监听调试的目的，不建议用这个方法去做别的事，当大量的任务被取消后，可以调用 remove(Runnable) and purge() 方法去进行回收。

Finalization
// 终止
A pool that is no longer referenced in a program AND has no remaining threads will be shutdown automatically. If you would like to ensure that unreferenced pools are reclaimed even if users forget to call shutdown(), then you must arrange that unused threads eventually die, by setting appropriate keep-alive times, using a lower bound of zero core threads and/or setting allowCoreThreadTimeOut(boolean).
Extension example. Most extensions of this class override one or more of the protected hook methods. For example, here is a subclass that adds a simple pause/resume feature:
// 当线程池不在被引用或者被有剩余的线程后，将会自动关闭，如果你忘记调用 shutdown()，又想确保无引用的线程池被回收，你必须安排没有使用的线程能够终止，通过设置合适的  keep-alive times ，使用低核心线程的池，并设置allowCoreThreadTimeOut(boolean)

 class PausableThreadPoolExecutor extends ThreadPoolExecutor {
   private boolean isPaused;
   private ReentrantLock pauseLock = new ReentrantLock();
   private Condition unpaused = pauseLock.newCondition();

   public PausableThreadPoolExecutor(...) { super(...); }

   protected void beforeExecute(Thread t, Runnable r) {
     super.beforeExecute(t, r);
     pauseLock.lock();
     try {
       while (isPaused) unpaused.await();
     } catch (InterruptedException ie) {
       t.interrupt();
     } finally {
       pauseLock.unlock();
     }
   }

   public void pause() {
     pauseLock.lock();
     try {
       isPaused = true;
     } finally {
       pauseLock.unlock();
     }
   }

   public void resume() {
     pauseLock.lock();
     try {
       isPaused = false;
       unpaused.signalAll();
     } finally {
       pauseLock.unlock();
     }
   }
 }
```

> 上面的 API 文档资料翻译的不是很好，但是可以用过上面的知识点进行总结：

1. 在 ThreadPoolExecutor 中定义了4个构造方法，而线程池的构造也是基于这4个方法，Executors 工厂方法中最终调用的也是这些构造方法。其它三个构造器也最终对下面的构造器进行调用，对下面的参数来做个解释
```
ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)
Creates a new ThreadPoolExecutor with the given initial parameters.
```
* corePoolSize 核心线程池的大小，理论上创建线程池后，池中是没有任何的线程的，只有当线程提到线程池中时，线程才会被创建，当然可以使用 prestartCoreThread() 和 prestartAllCoreThreads() 去预启动线程，当线程池中的线程超过corePoolSize 时，任务就会被加到 Queue 中等待。
* maximumPoolSize 线程池中最大的线程数
* keepAliveTime 一个线程在空闲多久后会被销毁，默认情况下，只有线程数超过 corePoolSize 时，keepAliveTime 才会起作用，当然也可以调用 allowCoreThreadTimeOut(boolean) 的方法，则当线程数小于corePoolSize时，keepAliveTime 也会起作用.
*  TimeUnit keepAliveTime的时间单位，有7种
DAYS
HOURS
MICROSECONDS
MILLISECONDS
MINUTES
NANOSECONDS
SECONDS
*  workQueue 工作队列，用来存储等待的任务：
ArrayBlockingQueue;
LinkedBlockingQueue;
SynchronousQueue;
*  threadFactory 创建线程的工厂
*  handler 拒绝任务的策略
ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。 
ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。 
ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务 

----------
然后来看关闭的方法， 看代码
```
import java.util.concurrent.*;
import java.util.List;

public class Test2 {
	public static void main(String[] args) throws Exception {
		ExecutorService myExecutorService  = Executors.newFixedThreadPool(5);
		for (int i = 0 ;i< 10 ;i++){
			myExecutorService.submit(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName());
					} catch (Exception e) {

					}
				}
			});
		}
		System.out.println("start shutdown");
		List<Runnable> runnables = myExecutorService.shutdownNow();
		System.out.println(runnables.size()); // 5

		// myExecutorService.shutdown();
	}
}
```

总结：
1. shutdown 不会立即关闭，而是等待所有任务（包括正在执行的，正在等待的）执行完毕后才会终止，同事不会接受新的任务
2. shutdownNow 则立即终止线程池，并尝试打断正在执行的任务，并且清空任务缓存队列，返回没有执行的任务的集合

----------
在来看下 提交的方法，提交任务有两个方法，一个是execute ，还有一个submit，区别就是：
1. execute 没有返回值  
2. submit 可以有返回值（使用Callable），也可以没有返回值（使用Runnable）
```
import java.util.concurrent.*;
import java.util.List;

public class Test3 {
	public static void main(String[] args) throws Exception {
		ExecutorService myExecutorService  = Executors.newFixedThreadPool(5);
		for (int i = 0 ; i < 10 ; i++) {
			Future<String> future = myExecutorService.submit(new Callable<String>() {

				@Override
				public String call() {
					try {
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName());
					} catch (Exception e) {

					}
					return Thread.currentThread().getName() + " callback";
				}
			});
			System.out.println(future.get());

		}
		System.out.println("start shutdown");
		myExecutorService.shutdown();

	}
}
```

参考文档
http://blog.csdn.net/sinat_36263171/article/details/52764205
http://donald-draper.iteye.com/blog/2366934
http://www.cnblogs.com/dolphin0520/p/3932921.html