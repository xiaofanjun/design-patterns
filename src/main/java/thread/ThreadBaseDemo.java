package thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程基础相关
 * <p>
 * 1：生命周期: new(新建)-->start(就绪)-->run(运行)-->block(sleep|wait)（堵塞）-->destroy（销毁）。
 * <p>
 * 2：多线程的实现方式: 1:extends Thread; 2:{@link SyncTest1} implements Runnable; 3:{@link ThreadBase1}  implements Callable; 4: {@link ThreadBase2}使用 线程池获取。
 * <p>
 * 3：进程与线程区别：进程是指在操作系统中正在运行的一个应用程序；线程是指进程内独立执行某个任务的一个单元；一个进程中可以包含多个线程。
 * <p>
 * 4：synchronized和Lock的区别：{@link ThreadBase4}
 * &nbsp;(1)：synchronized是Java内置的关键字，在jvm层面，Lock是Java接口;
 * &nbsp;(2)：synchronized无法判断是否获取到锁，Lock可以；
 * &nbsp;(3)：synchronized可以自动释放锁，Lock需要在finally中手动释放锁（容易造成死锁）；
 * &nbsp;(4)：synchronized当有线程等待时，会一直等，而Lock可以不用等，直接结束。
 * &nbsp;(5): synchronized的锁可重入，不可中断，非公平，而Lock可重入，可中断，可公平。
 * &nbsp;(6): Lock锁适合大量同步的代码同步问题，synchronized适合少量的。
 */
public class ThreadBaseDemo {
}

/**
 * 实现 Callable 方式实现多线程
 * <p>
 * 优点(与{@link SyncTest1} implements Runnable 方式相比)：1：可以提供返回值；2：可以抛出异常
 * <p>
 * 场景以及使用： 和 Runnable 使用基本相同；使用场景 就是需要返回值，或者需要抛出异常时使用;
 */
class ThreadBase1 implements Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadBase1 threadBase1 = new ThreadBase1();
        // 与实现 Runnable 接口相比多的一步操作
        FutureTask<String> ft = new FutureTask<String>(threadBase1);
        Thread thread1 = new Thread(ft);
        thread1.start();
        //这个必须等线程start调用get() 方法才行，否则该线程就会进入到等待状态;
        String resultCall = ft.get();
        System.out.println("线程返回结果为：" + resultCall);
    }

    @Override
    public String call() throws Exception {
        return "当前线程为：" + Thread.currentThread().getName();
    }
}

/**
 * 使用线程池(ThreadPoolExecutor)获取线程
 * <p>
 * 使用场景：处理大量的异步任务，为了减少每个任务的调用开销;
 * <p>
 * 原理：从{@link ThreadPoolExecutor }ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,TimeUnit,workQueue)构造函数来解释：
 * <p>
 * 设：corePoolSize = 6 ; maximumPoolSize = 10; 当期线程数量 = x;
 * 总结：
 * &nbsp; 1：当线程池中的线程数量为：4 < corePoolSize时，就会创建新的线程来执行新添加的任务。
 * &nbsp; 2：当线程池中的线程数量为：6 >= corePoolSize时，且workQueue未满，那么向workQueue中添加任务。
 * &nbsp; 3: 当线程池中的线程数量为：8 > corePoolSize时，且workQueue已满，但 < maximumPoolSize 时，那么创建新的线程类处理新添加任务。
 * &nbsp; 4: 当线程池中的线程数量为：10 = maximumPoolSize时，就使用RejectedExecutionHandler来执行拒绝策略。
 * 最后:
 * &nbsp;  x < corePoolSize ,创建线程。
 * &nbsp;  corePoolSize <= x < workQueue , 向workQueue添加任务。
 * &nbsp;  corePoolSize < x && workQueue已满 < maximumPoolSize, 创建线程。
 * &nbsp;  x > maximumPoolSize ，用RejectedExecutionHandler来拒绝。
 */
class ThreadBase2 {

    public void test1() throws InterruptedException {
        /**
         * 实例化线程池
         * @param corePoolSize: 核心池大小 (<= maximumPoolSize)
         * @param maximumPoolSize: 线程池中能拥有最多线程数
         * @param keepAliveTime: 线程没有任务执行时最多保持多久时间会终止
         * @param TimeUnit: 参数keepAliveTime的时间单位
         * @param workQueue: 一个阻塞队列，用来存储等待执行的任务
         */
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(6, 10,
                0L, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>());

        System.out.println("初始化线程核心池数量：" + threadPool.getCorePoolSize());
        for (int i = 0; i < 15; i++) {
            ThreadBase2_1 task = new ThreadBase2_1(i);
            //线程池中加入一个任务 注意： 并不是一个线程
            threadPool.execute(task);
            System.out.println("当前线程池中数量：" + threadPool.getPoolSize()
                    + "--当前核心池数量：" + threadPool.getCorePoolSize()
                    + "--当前队列中等待执行的任务数量：" + threadPool.getQueue().size()
                    + "--当前已执行完的任务数量：" + threadPool.getCompletedTaskCount());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadBase2 demo = new ThreadBase2();
        demo.test1();
    }

}

class ThreadBase2_1 implements Runnable {
    private int taskNum;

    public ThreadBase2_1(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
//        System.out.println("线程" + taskNum + "执行");
        ThreadUtil.printCurrentThreadInfo("run", 2000);
    }
}

/**
 * Lock 锁
 */
class ThreadBase4 {
    private Lock lock = new ReentrantLock();

    public void testLock() {

    }

    public static void main(String[] args) {

    }

}