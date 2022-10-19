package thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.redis_shopping.test.thread.Test02
 * @Date: 2022年10月17日 21:29
 * @Description:
 */
//联系Thread，实现多线程同步下载图片
public class Test02 extends Thread{
    private String url;//网络图片地址
    private String name;//保存的文件名
    public Test02 (String url,String name){
        this.url=url;
        this.name=name;
    }
    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downLoader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02("https://i2.hdslb.com/bfs/face/83bb511365da513c55aa3d1958524f3b7db40684.jpg", "1.jpg");
        Test02 test03 = new Test02("https://i2.hdslb.com/bfs/face/83bb511365da513c55aa3d1958524f3b7db40684.jpg", "2.jpg");
        Test02 test04 = new Test02("https://i2.hdslb.com/bfs/face/83bb511365da513c55aa3d1958524f3b7db40684.jpg", "3.jpg");
        test02.start();
        test03.start();
        test04.start();
    }
}

//下载器
class WebDownLoader{
    //下载方法
    public void downLoader(String url,String name)  {

        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downLoader方法出现问题");
        }
    }
}
