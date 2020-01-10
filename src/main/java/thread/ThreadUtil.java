package thread;

/**
 * 线程工具类
 */
public class ThreadUtil {

    /**
     * 打印当前线程信息
     *
     * @param methodType
     */
    public static void printCurrentThreadInfo(String methodType, int millis) {
        try {
            System.out.println(Thread.currentThread().getName() + "线程执行了" + methodType + "方法");
            Thread.sleep(millis);
            System.out.println(Thread.currentThread().getName() + "执行" + millis + "秒钟之后完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
