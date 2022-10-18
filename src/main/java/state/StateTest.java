package state;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: state.StateTest
 * @Date: 2022年10月18日 15:31
 * @Description:
 */
//观察测试线程的状态
public class StateTest {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("//////");
            }
        });
        //1.观察状态
        Thread.State state = thread.getState();
        System.out.println(state);//NEW

        //2.观察启动后
        thread.start();//启动线程
        state = thread.getState();
        String s = state.toString();
        String s1 = s.toLowerCase();
        System.out.println(s1);//RUNNABLE
        //只要线程不终止，就一直处于输出状态
        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = thread.getState();//更新线程状态
            System.out.println(state);//输出线程状态
        }

        /*
         * 死亡之后的线程不可以再次启动*/
//        thread.start();//启动线程

    }
}
