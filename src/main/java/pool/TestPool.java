package pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: pool.TestPool
 * @Date: 2022年10月19日 14:28
 * @Description:
 */

//测试线程池
public class TestPool {
    public static void main(String[] args) {
        //1.创建服务，创建线程池
        //newFixedThreadPool参数为：线程池的大小
        ExecutorService service= Executors.newFixedThreadPool(10);
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //2.关闭链接
        service.shutdown();


//        MyThread myThread = new MyThread();
//        new Thread(myThread, "小黄").start();
    }
}

