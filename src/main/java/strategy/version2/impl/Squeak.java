package strategy.version2.impl;

import strategy.version2.QuackBehavior;

/**
 * @ClassName Squeak
 * @Description todo
 * @Auth zhangq
 * @Date 2019/7/13 下午10:29
 * @Version 1.0
 **/
public class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("吱吱叫");
    }
}
