package com.cocoa.priority;

/**
 * -在操作系统，线程可以划分优先级，优先级高的线程得到的cpu资源也会多， CPU也会优先执行优先级高的线程
 * -在java 中， 设置优先级的方法，setPriority，优先级的等级为1-10，也可以使用下面的三个常量
 * static int	MAX_PRIORITY   线程可以具有的最高优先级。
 * static int	MIN_PRIORITY   线程可以具有的最低优先级。
 * static int	NORM_PRIORITY  分配给线程的默认优先级。
 *
 * - 优先级具有继承特性
 * - 优先级高的会被先执行，但不不代表总是会被先执行，就是不一定的(比如下面的代码中，Thread10并不是最先执行完毕的，Thread1也并不总是在最后一个完成)
 *
 */
public class test {

    public static void main(String[] args) {

        for (int i = 1; i < 22; i++) {
            Thread50 thread50 = new Thread50();
            thread50.setName("thread" + i);
            thread50.setPriority(i);
            thread50.start();

        }


    }

}
