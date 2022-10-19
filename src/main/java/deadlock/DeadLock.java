package deadlock;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: deadlock.DeadLock
 * @Date: 2022年10月19日 08:33
 * @Description:
 */

//死锁：多个相乘互相持有对方需要的资源，然后形成僵持
public class DeadLock  {
    public static void main(String[] args) {
        MackUp xh = new MackUp(0, "小红");
        MackUp xb = new MackUp(1, "小白");
        xh.start();
        xb.start();
    }
}

//口红

class Lipstick {

}

class Mirror {

}

class MackUp extends Thread {
    //需要的资源只有一份，用static来保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;//使用化妆品的人

    public MackUp(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        //化妆
        makeup();
    }


    /**
     * 死锁产生的四个必要条件
     * 1.互斥条件：一个资源每次只能被一个进程使用。
     * 2.请求与保持条件：一个进程因请求资源而阻塞时，对以获得的资源保持不放。
     * 3.不剥夺条件：进程以获得的资源，在未使用完之前，不能强行剥夺。
     * 4.循环等待条件：诺干进程之间形成一种头尾相接的循环等待资源关系
     */
    /*

    当前为死锁

    if (choice == 0) {
            synchronized (lipstick){
                //获得口红的锁
                System.out.println(this.girlName+"获得口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println(this.girlName+"获得镜子的锁");
                }
            }
        }else {
            synchronized (mirror){
                //获得口红的锁
                System.out.println(this.girlName+"获得jingzi的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick){
                    System.out.println(this.girlName+"获得kouhong的锁");
                }
            }
        }

     */
    //化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup(){
        if (choice == 0) {
            synchronized (lipstick){
                //获得口红的锁
                System.out.println(this.girlName+"获得口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
            }
        }else {
            synchronized (mirror){
                //获得口红的锁
                System.out.println(this.girlName+"获得镜子的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lipstick){
                System.out.println(this.girlName+"获得口红的锁");
            }
        }
    }
}

