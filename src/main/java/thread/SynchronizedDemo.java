package thread;

/**
 * synchronized 关键字说明:
 * <p>
 * 作用：能够保证同一时刻最多只有一个线程执行该段代码，以达到并发安全的效果
 * <p>
 * 形式分类：对象锁(同步代码块锁，方法锁)； 类锁(static方法锁，class锁)
 * <p>
 * 总结 ： 同步代码块锁：锁的是同一个对象的不同线程对一段代码块的锁;  方法锁：      锁的是同一个对象的不同线程对一个方法的锁;
 * &nbsp; class锁：    锁的是不同对象的不同线程对一段代码的锁;      static方法锁： 锁的是不同对象的不同线程对一个方法的锁;
 * <p>
 * 锁的作用范围(小--------->大)：同步代码块锁------>方法锁------>class锁------>static方法锁
 * <p>
 * 使用： 对于使用来说，如果要是锁的是只是同一个对象的话，那么就需要用对象锁，然后判断是要锁住一个方法中的一段代码块，还是是整个
 * 方法需要上锁；反之，看类锁是否满足需求；具体使用，应根据具体的业务需求来选取。
 */
public class SynchronizedDemo {
}

/**
 * 对象锁-------->同步代码块锁
 * <p>
 * 如果该代码块没有加 synchronized ：
 * 执行结果可能为：
 * Thread-1线程执行了run方法
 * Thread-0线程执行了run方法
 * Thread-1执行2秒钟之后完毕
 * Thread-0执行2秒钟之后完毕
 * <p>
 * 添加了 synchronized 关键字之后：
 * 执行结果肯定为（一个线程执行完之后，再去执行另一个线程;（可能是线程0先执行））：
 * Thread-1线程执行了run方法
 * Thread-1执行2秒钟之后完毕
 * Thread-0线程执行了run方法
 * Thread-0执行2秒钟之后完毕
 * 总结：如果用两个线程分别为两个对象，那么该锁也不会起作用，所以该锁也是对于同一个对象的。
 */
class SyncTest1 implements Runnable {
    Object object = new Object();

    public static void main(String[] args) {
        SyncTest1 syncTest1 = new SyncTest1();
        Thread thread1 = new Thread(syncTest1);
        Thread thread2 = new Thread(syncTest1);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + "线程执行了run方法");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "执行2秒钟之后完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 对象锁-------->方法锁
 * 用法 ：用法就是在普通的方法前添加个 synchronized 关键字即可
 * <p>
 * 在下面这个demo中执行结果为:
 * Thread-1线程执行了run方法
 * Thread-0线程执行了run方法
 * Thread-1执行2秒钟之后完毕
 * Thread-0执行2秒钟之后完毕
 * 从这个结果可以看到锁好像没有起作用，那么为什么会这样呢？这是因为方法锁又叫 ‘this锁’，它锁的是同一个对象，也就是说对于同一个对
 * 象的不同线程，方法锁才会起作用。
 * <p>
 * 总结：方法锁又叫this锁，只有对于同一个对象的不同线程，该锁才会起到作用
 */
class SyncTest2 implements Runnable {

    public static void main(String[] args) {
        SyncTest2 syncTest1 = new SyncTest2();
        SyncTest2 syncTest2 = new SyncTest2();
        Thread thread1 = new Thread(syncTest1);
        Thread thread2 = new Thread(syncTest2);
        thread1.start();
        thread2.start();
    }

    @Override
    public synchronized void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "线程执行了run方法");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "执行2秒钟之后完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 类锁-------->static方法锁
 * <p>
 * 使用：在静态方法前添加 synchronized 关键字即可
 * <p>
 * 到这里应该可以看到，该例子使用是两个不同的对象作为两个线程，但是锁照样起作用了；所以，对象锁，锁的是同一个对象，那么对于不同对
 * 象那么就可以使用到static方法锁了。
 */
class SyncTest3 implements Runnable {

    public static void main(String[] args) {
        SyncTest3 syncTest1 = new SyncTest3();
        SyncTest3 syncTest2 = new SyncTest3();
        Thread thread1 = new Thread(syncTest1);
        Thread thread2 = new Thread(syncTest2);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        method1();
    }

    public static synchronized void method1() {
        try {
            System.out.println(Thread.currentThread().getName() + "进入到了静态方法");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "离开静态方法，并释放锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 类锁-------->class锁
 * <p>
 * 使用: 在需要锁代码块上添加 synchronized 关键字，不过关键字中传入的是要锁住的那个类
 * <p>
 * 通过该例子可以看出锁起作用了，所以说该锁锁的是不同对象的，只要是 SyncTest4这个类的，被锁的这段代码，那么该类就会被锁住
 */
class SyncTest4 implements Runnable {

    public static void main(String[] args) {
        SyncTest4 syncTest1 = new SyncTest4();
        SyncTest4 syncTest2 = new SyncTest4();
        Thread thread1 = new Thread(syncTest1);
        Thread thread2 = new Thread(syncTest2);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        synchronized (SyncTest4.class) {
            try {
                System.out.println(Thread.currentThread().getName() + "线程执行了run方法");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "执行2秒钟之后完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

