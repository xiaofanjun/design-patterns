package strategy.version2.impl;

import strategy.version2.FlyBehavior;

/**
 * @ClassName FlyNoWay
 * @Description todo
 * @Auth zhangq
 * @Date 2019/7/13 下午10:28
 * @Version 1.0
 **/
public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("我不是会飞的");
    }
}
