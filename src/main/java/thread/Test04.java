package thread;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.redis_shopping.test.thread.Test04
 * @Date: 2022年10月18日 08:37
 * @Description:
 */
public class Test04 implements Runnable {
    //票数
    private  int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"票");
        }
    }
//发现异常：多个线程操作同一资源的情况下，线程不安全，数据紊乱
    /**
     * 老师拿到了第10票
     * 小王拿到了第9票
     * 小明拿到了第10票
     * 小王拿到了第8票
     * 老师拿到了第7票
     * 小明拿到了第6票
     * 小王拿到了第5票
     * 小明拿到了第3票
     * 老师拿到了第4票
     * 老师拿到了第2票
     * 小明拿到了第2票
     * 小王拿到了第1票
     * @param args
     */

    public static void main(String[] args) {
        Test04 test04 = new Test04();
        new Thread(test04,"小明").start();
        new Thread(test04,"老师").start();
        new Thread(test04,"小王").start();
    }
}
