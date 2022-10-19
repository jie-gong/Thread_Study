package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: Gaoji.TestLock
 * @Date: 2022年10月19日 09:11
 * @Description:
 */
public class TestLock {
    public static void main(String[] args) {

        TestLock02 testLock02 = new TestLock02();
        new Thread(testLock02, "小王").start();
        new Thread(testLock02, "小孙").start();
        new Thread(testLock02, "小黄").start();

    }
}

class TestLock02 implements Runnable {
    int tickNumber = 10;

    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock.lock();//加锁
                if (tickNumber > 0) {

                    System.out.println(Thread.currentThread().getName() + "获得了第" + tickNumber-- + "张票");
                } else {
                    break;
                }
            } finally {
                //解锁
                lock.unlock();
            }


        }

    }
}
