package testlambda;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: testlambda.TestLambda01
 * @Date: 2022年10月18日 10:35
 * @Description:
 */

/**
 * 推导lambda表达式
 */
public class TestLambda01 {
    /**
     * 3.静态内部类
     */
    static class Like2 implements ILike {
        @Override
        public void Lambda() {
            System.out.println("I Like Lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.Lambda();
        like = new Like2();
        like.Lambda();


        /**
         * 4.局部内部类
         */
        class Like3 implements ILike {
            @Override
            public void Lambda() {
                System.out.println("I Like Lambda3");
            }
        }
        like = new Like3();
        like.Lambda();


        /**
         * 5.匿名内部类,没有类的名称，必须借助接口或者父类
         */
        like = new ILike() {
            @Override
            public void Lambda() {
                System.out.println("I Like Lambda4");
            }
        };
        like.Lambda();
        

        /**
         * 6.用lambda简化
         */
        like = () -> {
            System.out.println("I Like Lambda5");
        };
        like.Lambda();
    }
}

/**
 * 1.定义一个函数式接口
 */
interface ILike {
    void Lambda();
}

/**
 * 2.实现类
 */
class Like implements ILike {
    @Override
    public void Lambda() {
        System.out.println("I Like Lambda");
    }
}


