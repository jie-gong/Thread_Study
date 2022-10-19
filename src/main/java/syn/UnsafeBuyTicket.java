package syn;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: syn.UnsafeBuyTicket
 * @Date: 2022年10月18日 16:27
 * @Description:
 */
//不安全的买票


//线程不安全  有负数
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket, "小王").start();
        new Thread(buyTicket, "小孙").start();
        new Thread(buyTicket, "小黄").start();
    }
}

class BuyTicket implements Runnable {

    int TicketNumber = 10;

    boolean flag = true;//外部停止线程方式

    @Override
    public void run() {

        //买票
        while (flag) {

            by();

        }

    }

    //同步方法synchronized ，锁的是this
    private synchronized void by() {

        //判断是否有票
        if (TicketNumber <= 0) {

            stop();

            return;
        }
        //模拟延迟
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName() + "拿到了，第" + TicketNumber-- + "张票");
    }

    //设置一个公开的方法，停止线程，切换标志位
    public void stop() {
        this.flag = false;
    }
}
