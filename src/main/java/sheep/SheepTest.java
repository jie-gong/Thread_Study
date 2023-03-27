package sheep;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: sheep.SheepTest
 * @Date: 2022年10月18日 11:45
 * @Description:
 */
//模拟网络延迟 ： 放大问题的发生性
public class SheepTest implements Runnable {
    //总票数
    private int tickerNums = 10;

    @Override
    public void run() {
        while (true) {
            if (tickerNums < 0) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("购票失败");
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + tickerNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        SheepTest sheepTest = new SheepTest();
        new Thread(sheepTest, "小明").start();
        new Thread(sheepTest, "小黄").start();
        new Thread(sheepTest, "小公").start();
        new Thread(sheepTest, "小李").start();
    }

}
