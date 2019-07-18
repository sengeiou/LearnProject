### Join

* Join 会使当前线程一直阻塞，直到 Join 的线程结束，或者被另外的线程中断
* Join(long millis) 方法内部是用 wait(long millis) 实现， 所以 Join 具有释放锁的特点，
而 sleep(long millis) 则不会释放锁




```$xslt
个人感觉，就是对当前线程加了阻塞块，具体等看了 wait 后再说

应用场景
在 <java 高并发编程详解> 中，作者使用一组线程去获取数据，主线程阻塞等待所有的子线程结束后，
汇总所有子线程收到的消息

```



