### Yield

让出当前线程的CPU资源，感觉没什么卵用！！！


### 总结 sleep 和 yield 的区别
1. 在 jdk1.5 前，yield 就是调用了 sleep(0) 的方法
2. sleep 会导致当前线程睡眠，不会消耗 CPU 资源
3. yield 是CPU 调度器的提示， 可能会导致线程的上下文切换, 使线程的 running 状态 切换到 runnable 状态
4. sleep 一定能睡眠， yield 则不能100% 保证
5. slepp 能被打断，抛出异常， yield 则不会



