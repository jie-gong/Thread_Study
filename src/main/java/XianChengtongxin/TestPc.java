package XianChengtongxin;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: XianChengtongxin.TestPc
 * @Date: 2022年10月19日 09:53
 * @Description:
 */
//测试：生产者消费者模型-->利用缓冲区解决：管程法


//生产者，产品，缓冲区
public class TestPc {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Productor(synContainer).start();
        new Thread(new Consumer(synContainer), "小黄").start();
    }

    /**
     * @author: 公杰
     * @Project: JavaLaity
     * @Pcakage: XianChengtongxin.TestPc.Chicken
     * @Date: 2022年10月19日 11:26
     * @Description:
     */ //产品
    static class Chicken {
        int id;

        public Chicken(int id) {
            this.id = id;
        }
    }

    /**
     * @author: 公杰
     * @Project: JavaLaity
     * @Pcakage: XianChengtongxin.TestPc.Consumer
     * @Date: 2022年10月19日 11:26
     * @Description:
     */ //消费者
    static class Consumer extends Thread {
        SynContainer container;

        public Consumer(SynContainer container) {
            this.container = container;
        }
        //消费方法

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "消费了-->" + container.pop().id + "只鸡");
            }

        }
    }


    /**
     * @author: 公杰
     * @Project: JavaLaity
     * @Pcakage: XianChengtongxin.TestPc.SynContainer
     * @Date: 2022年10月19日 11:26
     * @Description:
     */ //缓冲区
    static class SynContainer {
        //需要一个容器大小
        Chicken[] chickens = new Chicken[10];

        //容器计数器
        int count = 0;

        //生产者放入产品
        public synchronized void push(Chicken chicken) {
            //如果容器满了，就需要消费者消费
            while (count == chickens.length) {
                //通知消费者消费  生产者等待
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //如果没有满，我们就需要丢入产品

            chickens[count] = chicken;
            count++;
            //可以通知消费者消费了。

            this.notifyAll();
        }

        //消费者消费产品
        public synchronized Chicken pop() {
            //判断能否消费
            while (count == 0) {
                //等待生产者生产，消费者等待

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //如果可以消费

            count--;
            Chicken chicken = chickens[count];
            this.notifyAll();
            //吃完了 通知生产者 生产

            return chicken;
        }

    }

    /**
     * @author: 公杰
     * @Project: JavaLaity
     * @Pcakage: XianChengtongxin.TestPc.Productor
     * @Date: 2022年10月19日 11:26
     * @Description:
     */ //生产者
    static class Productor extends Thread {

        SynContainer container;

        public Productor(SynContainer container) {
            this.container = container;
        }
        //生产方法

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("生产了" + i + "只鸡");
                container.push(new Chicken(i));
            }
        }
    }
}

