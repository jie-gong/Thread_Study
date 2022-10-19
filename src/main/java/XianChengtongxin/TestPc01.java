package XianChengtongxin;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: XianChengtongxin.TestPc01
 * @Date: 2022年10月19日 11:36
 * @Description:
 */

//测试生产者消费者之间的问题2，信号灯法
public class TestPc01 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }

}

//生产者-->演员


class Player extends Thread {
    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.player("欢乐喜剧人");
            } else {
                this.tv.player("抖音短视频");
            }
        }
    }
}

//消费者-->观众
class Watcher extends Thread {
    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//产品-->节目
class TV {
    //演员表演，观众等待 if  True
    //观众观看，演员等待 if  False
    String voice;//表演的节目
    boolean flag = true;

    //表演
    public synchronized void player(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了" + voice);
        //通知观众观看
        this.notifyAll();//通知唤醒
        this.voice = voice;
        this.flag = !this.flag;
    }

    //观看
    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了" + voice);
        System.out.println();
        //通知演员表演
        this.notifyAll();
        this.flag = !flag;

    }
}

