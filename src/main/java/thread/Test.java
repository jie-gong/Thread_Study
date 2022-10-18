package thread; /**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.redis_shopping.test.thread.Test
 * @Date: 2022年10月17日 09:18
 * @Description:
 */

/**
 * 创建线程方式一：继承Thread类，重写run()方法，调用start开启线程
 *
 * 总结：注意！线程开启不一定立即执行，由CPU调度执行
 */
public class Test extends Thread {
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
        Test test = new Test();
        //调用start（）方法  开启线程
        test.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程" + i);
        }
    }


}
