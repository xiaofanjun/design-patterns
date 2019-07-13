package strategy.version2;

import strategy.version2.impl.FlyWithWings;
import strategy.version2.impl.Quack;

/**
 * @ClassName Test
 * @Description todo
 * @Auth zhangq
 * @Date 2019/7/13 下午10:33
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        SuperDuck mallardDuck = new MallardDuck();

        mallardDuck.setFlyBehavior(new FlyWithWings());//假如mallarDuck 不会飞了　这里传入一个　new FlyNoWay()即可
        mallardDuck.setQuackBehavior(new Quack());//这个同理

        mallardDuck.display();
        mallardDuck.performQuack();
        mallardDuck.performFly();
    }
}
