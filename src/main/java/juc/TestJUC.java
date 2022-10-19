package juc;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: juc.TestJUC
 * @Date: 2022年10月18日 21:24
 * @Description:
 */
//测试JUC安全类型的集合
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                copyOnWriteArrayList.add(Thread.currentThread().getName());
            }
            ).start();
//            System.out.println(copyOnWriteArrayList.size());

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(copyOnWriteArrayList.size());
    }
}
