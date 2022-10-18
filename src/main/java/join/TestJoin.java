package join;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: join.TestJoin
 * @Date: 2022年10月18日 15:11
 * @Description:
 */

//测试join方法 ——————-可以想象为插队
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("鸡汤来喽"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);


        for (int i = 0; i < 500; i++) {
            if (i==200){
                thread.start();
                thread.join();//插队
            }
            System.out.println("main"+i);
        }
    }
}
