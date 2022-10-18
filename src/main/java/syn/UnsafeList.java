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
    public static void main(String[] args) throws InterruptedException {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> strings.add(Thread.currentThread().getName())).start();
        }
        Thread.sleep(10);
        System.out.println(strings.size());
    }
}
