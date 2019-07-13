package strategy.version1;

/**
 * @ClassName SuperDuck
 * @Description 鸭子超类
 * @Auth zhangq
 * @Date 2019/7/13 下午7:57
 * @Version 1.0
 **/
public abstract class SuperDuck {

    /**
     * @return void
     * @Author zhangq
     * @Description //叫
     * @Date 下午8:02 2019/7/13
     * @Param []
     **/
    void quack() {
        System.out.println("普通鸭子的叫：呱呱叫...");
    }

    /**
     * @return void
     * @Author zhangq
     * @Description //游泳
     * @Date 下午8:01 2019/7/13
     * @Param []
     **/
    void swim() {
        System.out.println("普通鸭子的游泳：游泳...");
    }

    /**
     * @return void
     * @Author zhangq
     * @Description // 飞
     * @Date 下午8:26 2019/7/13
     * @Param []
     **/
    void flay() {
        System.out.println("我飞呀飞...");
    }

    /**
     * @return void
     * @Author zhangq
     * @Description //因为每一个鸭子的外观都不一样，所以这个方法是抽象的
     * @Date 下午8:00 2019/7/13
     * @Param []
     **/
    abstract void display();
}
