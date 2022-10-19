package pool;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: pool.MyThread
 * @Date: 2022年10月19日 14:49
 * @Description:
 */
class MyThread implements Runnable {
    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName() + "..");
    }
}
