package strategy.version2.impl;

import strategy.version2.FlyBehavior;

/**
 * @ClassName FlyWithWings
 * @Description 实现
 * @Auth zhangq
 * @Date 2019/7/13 下午10:27
 * @Version 1.0
 **/
public class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("我是一个会飞的");
    }
}
