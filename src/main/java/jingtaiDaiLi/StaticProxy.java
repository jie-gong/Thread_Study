package jingtaiDaiLi;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: jingtaiDaiLi.StaticProxy
 * @Date: 2022年10月18日 09:56
 * @Description:
 */


/*
静态代理模式总结
1.真实对象和代理对象都要实现同一个接口
2.代理对象要代理真实角色
 */
public class StaticProxy {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("我爱你")).start();

        new WeddingCompany(new You()).HappyMarry();

        WeddingCompany weddingCompany = new WeddingCompany(new You());
        //好处：
        //代理对象（  WeddingCompany  ）可以做很多真实对象（You）做不了的事情
        //真实对象专注做自己的事情
        weddingCompany.HappyMarry();
    }
}

interface Marry {
    //人间四大喜事
    //久旱逢甘露
    //他乡遇故知
    //洞房花烛夜
    //金榜题名时
    void HappyMarry();
}

//真实角色，我去结婚
class You implements Marry {

    @Override
    public void HappyMarry() {
        System.out.println("我要结婚了，超开心");
    }
}

//代理角色,帮助我结婚
class WeddingCompany implements Marry {
    //代理谁呢————>真实目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();//这就是真实对象结婚
        after();
    }

    private void after() {
        System.out.println("结婚前布置现场");
    }

    private void before() {
        System.out.println("结婚之后收尾款");
    }
}
