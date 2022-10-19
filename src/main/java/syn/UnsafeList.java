package syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: syn.UnsafeList
 * @Date: 2022年10月18日 17:30
 * @Description:
 */
public class UnsafeList {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
