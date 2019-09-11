### Interrupt


* interrupt() 打断线程的阻塞 （wait ，slepp，join）
* 如果线程是死亡状态，调用 interrupt 则无效果
* 看下面的代码，发现interrupted 和 isInterrupted都是调用了同一个方法，无非一个是静态方法，一个成员方法，
一个清除了打断的标记，一个没有清除

```$xslt
public static boolean interrupted() {
        return currentThread().isInterrupted(true);
    }
public boolean isInterrupted() {
        return isInterrupted(false);
    }
private native boolean isInterrupted(boolean ClearInterrupted);    

```

*  