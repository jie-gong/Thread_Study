package sheep;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: sheep.SheepTest02
 * @Date: 2022年10月18日 14:38
 * @Description:
 */

//模拟倒计时
public class SheepTest02 {
    public static void teaDown() throws InterruptedException {
        int number = 10;
        //模拟倒计时
        while (true) {
            Thread.sleep(1000);
            System.out.println(number--);
            if (number <= 0) {
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        teaDown();
//        打印当前系统时间
        Date startTime = new Date(System.currentTimeMillis());//获取系统当前时间
        while (true) {
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            startTime = new Date(System.currentTimeMillis());//更新系统当前时间
            Thread.sleep(1000);
        }

//        int number = 3;
//        while (true) {
//            String num = String.valueOf(number);
////            text.setText(num + "跳过");
//            System.out.println(num);
//            number--;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (number==0){
//                break;
//            }
//        }
    }
    }
