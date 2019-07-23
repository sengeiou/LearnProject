public class Test extends Thread{ 
	
// join 的功能 是使用 wait(long) 方法来实现的， 所以join (long) 具有释放锁的特点

// 1249    public final synchronized void join(long millis)
// 1250    throws InterruptedException {
// 1251        long base = System.currentTimeMillis();
// 1252        long now = 0;
// 1253
// 1254        if (millis < 0) {
// 1255            throw new IllegalArgumentException("timeout value is negative");
// 1256        }
// 1257
// 1258        if (millis == 0) {
// 1259            while (isAlive()) {  
// 1260                wait(0);
// 1261            }
// 1262        } else {
// 1263            while (isAlive()) {
// 1264                long delay = millis - now;
// 1265                if (delay <= 0) {
// 1266                    break;
// 1267                }
// 1268                wait(delay);
// 1269                now = System.currentTimeMillis() - base;
// 1270            }
// 1271        }
// 1272    }


//  join 和 sleep 有什么区别    
//  join 具有释放锁的特点
//  sleep 则不会释放所 
// 查看 demo1 和 demo2 代码   


	public static void main(String[] args)  {
        try {


                Test t = new Test();
                t.start();
                t.setName("hahah");
                t.lock();  // 通过查看 join 的源码，自定义了 lock 方法，实现和join 一样的效果
                System.out.println("end");

        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

    public synchronized  void lock() throws InterruptedException {
        while(isAlive()){
        	System.out.println(Thread.currentThread().getName()+" in lock method");
            wait(0);
        }
    }



    @Override
    public void run() {
        super.run();
        try {

            int i = 1000;
            while( i > 5) {
                i--;
                System.out.println("===="+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}