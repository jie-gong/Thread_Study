package syn;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: syn.UnsafeBank
 * @Date: 2022年10月18日 16:55
 * @Description:
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(200, "银行存款");
        Drawing woff = new Drawing(account, 100, "老婆");
        Drawing me = new Drawing(account, 50, "我");
        me.setPriority(Thread.MIN_PRIORITY);
        me.start();
        woff.setPriority(Thread.MAX_PRIORITY);
        woff.start();
    }
}

//账户
class Account {
    int money;//余额
    String name;//卡名

    public Account(int money, String name) {//构造方法
        this.money = money;
        this.name = name;
    }

}

//银行 模拟取款
class Drawing extends Thread {
    private Account account;//账户
    int drawing; //取了多少钱
    int nowMoney;//现在手里还有多少钱

    public Drawing(Account account, int drawing, String name) {
        super(name);
        this.account = account;
        this.drawing = drawing;
//        this.name = name;
    }

    @Override
    public void run() {
        //锁的对象是变化的量
        synchronized (account) {
            //判断有没有钱
            if (account.money - drawing < 0) {
                System.out.println(Thread.currentThread().getName() + "余额不足,无法操作");
                return;
            }
            try {//可以放大问题的发生性
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额=余额-你取的钱
            account.money = account.money - drawing;
            //你手里的钱
            nowMoney = nowMoney + drawing;

            System.out.println(account.name + "余额为:" + account.money);
            System.out.println(this.getName() + "手里的钱:" + nowMoney);
        }
    }
}
