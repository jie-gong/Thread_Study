package Daemon;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: Daemon.TestDaemon
 * @Date: 2022年10月18日 16:05
 * @Description:
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认是false 表示守护线程，正常的线程都是用户线程.....
        thread.start();//上帝守护线程启动
        Thread thread1 = new Thread(you);
        thread1.start();//you   用户线程启动
    }
}

//上帝
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑着你");
        }
    }
}
//你
class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("你一生都开心的活着"+i);
        }
        System.out.println("=======goodbye!");//Hello,World;
    }
}
