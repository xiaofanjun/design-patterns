package strategy.version2;

/**
 * @ClassName SuperDuck
 * @Description todo
 * @Auth zhangq
 * @Date 2019/7/13 下午10:34
 * @Version 1.0
 **/
public abstract class SuperDuck {
    //叫行为
    QuackBehavior quackBehavior;
    //飞行为
    FlyBehavior flyBehavior;

    /**
     * @return void
     * @Author zhangq
     * @Description //让飞行为这个接口去飞
     * @Date 下午10:42 2019/7/13
     * @Param []
     **/
    public void performFly() {
        flyBehavior.fly();
    }

    /**
     * @return void
     * @Author zhangq
     * @Description //让叫行为这个接口去叫
     * @Date 下午10:42 2019/7/13
     * @Param []
     **/
    public void performQuack() {
        quackBehavior.quack();
    }

    /**
     * @return void
     * @Author zhangq
     * @Description //这个的好处是可以让鸭子灵活设置自己该行为方式是怎样的
     * @Date 下午11:01 2019/7/13
     * @Param [fb]
     **/
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    //和fly行为同理
    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    public void swim() {
        System.out.println("游个泳");
    }

    public abstract void display();
}
