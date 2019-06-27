### Thread.sleep

sleep 有一个重要的特性，不会放弃持有的锁
```
        try {
            Thread.sleep(1000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


```

JDK 1.5 后引入了枚举类 TimeUnit ， 对 sleep 进行了封装
```$xslt
// 
TimeUnit.HOURS.sleep(1);
```

============

* 操作系统中，CPU竞争有很多种策略。Unix系统使用的是时间片算法，而Windows则属于抢占式的。
* Thread.Sleep(0)的作用，就是“触发操作系统立刻重新进行一次CPU竞争”  


