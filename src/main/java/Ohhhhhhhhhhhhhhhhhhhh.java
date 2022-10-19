import com.sun.corba.se.impl.orbutil.closure.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: PACKAGE_NAME.Ohhhhhhhhhhhhhhhhhhhh
 * @Date: 2022年10月19日 15:01
 * @Description:
 */

//回顾总结线程的创建
public class Ohhhhhhhhhhhhhhhhhhhh {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread01 myThread01 = new MyThread01();
        MyThread02 myThread02 = new MyThread02();


        //++++++++++++++++++++++++++++
        myThread.start();


        //—————————————————————————————
        /**
         *   也可以直接使用自带的run方法来实现？
         *           myThread01.run();
         */
        //使用代理类来实现
        new Thread(myThread01).start();


        //****************************
        FutureTask<Integer> future = new FutureTask<Integer>(new MyThread02());
        //可以使用 Thread来启动
        new Thread(future).start();

        try {
            Integer integer = future.get();
            System.out.println("MyThread02++++++返回的值为" + integer);
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        try {
            myThread02.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//1.Thread
class MyThread extends Thread {
    //重写run方法
    @Override
    public void run() {
        //实现Thread的run方法
        System.out.println("MyThread-----这个地放用来重写run方法");
    }
}

//2.重写Runnable接口
class MyThread01 implements Runnable {
    @Override
    public void run() {
        //实现Runnable接口
        System.out.println("MyThread01_____这个地放用来重写run方法");
    }
}

//3实现Callable接口
class MyThread02 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("MyThread02++++++这个地放用来重写run方法");
        return 100;
    }
}