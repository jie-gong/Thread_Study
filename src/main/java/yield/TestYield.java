package yield;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: yied.TestYied
 * @Date: 2022年10月18日 15:04
 * @Description:
 */

//测试礼让线程
//礼让不一定成功
public class TestYield {
    public static void main(String[] args) {
        Yield yield = new Yield();
        for (int i = 0; i < 10; i++) {
            new Thread(yield,"a").start();
            new Thread(yield,"b").start();
        }

    }
}

class Yield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}
