package thread;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.redis_shopping.test.thread.Test03
 * @Date: 2022年10月18日 08:27
 * @Description:
 */

//创建线程方式二：实现runnable接口，重写run方法，执行线程需要丢入runnable的接口实现类。
public class Test03 implements Runnable{
    @Override
    public void run() {
//        super.run();
//        run方法线程体

        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码" + i);
        }

    }
//        main线程，主线程

    public static void main(String[] args) {

        //创建一个线程对象
        Test03 test = new Test03();
        //创建一个线程对象，通过线程对象来开启我们的线程
        //调用start（）方法  开启线程
        new Thread(test).start();
        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程" + i);
        }
    }
}
