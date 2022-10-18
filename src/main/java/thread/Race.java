package thread;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.redis_shopping.test.thread.Race
 * @Date: 2022年10月18日 09:12
 * @Description: 模拟龟兔赛跑
 */
public class Race implements Runnable {

    //胜利者
    private String winner;

    @Override
    public void run() {
        //模拟兔子睡觉
        if (Thread.currentThread().getName().equals("兔子")){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i <= 100; i++) {
            //判断比赛是否结束
            boolean flag = gameOver(i);
            //如果比赛结束了，就停止程序
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    private boolean gameOver(int steps) {
        //判断 是否有胜利者
        if (winner != null) {//已经存在胜利者了
            return true;
        }
        {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("胜利者是" + winner);
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "乌龟").start();
        new Thread(race, "兔子").start();
    }
}
