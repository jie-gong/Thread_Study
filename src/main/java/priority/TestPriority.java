package priority;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: priority.TestPriority
 * @Date: 2022年10月18日 15:49
 * @Description:
 */


//测试线程的优先级
public class TestPriority {
    public static void main(String[] args) {
        //主线程默认的优先级
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();
        Thread thread = new Thread(myPriority);
        Thread thread1 = new Thread(myPriority);
        Thread thread2 = new Thread(myPriority);
        Thread thread3 = new Thread(myPriority);
        Thread thread4 = new Thread(myPriority);
        Thread thread5 = new Thread(myPriority);
        thread.start();
        thread1.setPriority(1);
        thread1.start();
        thread2.setPriority(4);
        thread2.start();
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread3.start();
        thread4.setPriority(2);
        thread4.start();
        thread5.setPriority(3);
        thread5.start();

    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}
