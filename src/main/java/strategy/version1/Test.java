package strategy.version1;

/**
 * @ClassName Test
 * @Description 测试类
 * @Auth zhangq
 * @Date 2019/7/13 下午8:06
 * @Version 1.0
 **/
public class Test {
    /**
     * @return void
     * @Author zhangq
     * @Description
     * @Date 下午8:07 2019/7/13
     * @Param [args]
     **/
    public static void main(String[] args) {
        SuperDuck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.swim();
        mallardDuck.quack();
        mallardDuck.flay();
        SuperDuck redHeadDuck = new RedHeadDuck();
        redHeadDuck.display();
        redHeadDuck.swim();
        redHeadDuck.quack();
    }
}
