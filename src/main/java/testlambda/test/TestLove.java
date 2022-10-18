package testlambda.test;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: testlambda.test.TestLove
 * @Date: 2022年10月18日 11:03
 * @Description:
 */
public class TestLove {
    //lambda表达式
    public static void main(String[] args) {
        //1
        Love love=(int a)->{
            System.out.println("I Love You"+a+"次");
        };
        //2
        love=a -> System.out.println("I love you"+a);
        //lambda表达式只有在一行代码的时候才能简化为一行，如果有多行，那么就用代码块包裹 “{}”
        //前提接口是函数式接口  多个参数也可以去掉参数类型 要去掉就都去掉 必须加上括号

        love.ILove(2);
    }
}
