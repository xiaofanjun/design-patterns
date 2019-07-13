package strategy.version2.impl;

import strategy.version2.QuackBehavior;

/**
 * @ClassName MuteQuak
 * @Description todo
 * @Auth zhangq
 * @Date 2019/7/13 下午10:30
 * @Version 1.0
 **/
public class MuteQuak implements QuackBehavior {
    public void quack() {
        System.out.println("什么都不做,不会叫");
    }
}
