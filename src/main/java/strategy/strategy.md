##策略模式
&nbsp;&nbsp;&nbsp;**定义了算法族，分别封装起来，让他们之间可以相互替换，此模式让算法的变化独立于使用算法的客户。<br>**
##设计原则
 &nbsp;&nbsp;&nbsp;1:找出应用中可能需要变化之处，把他们独立出来，不要和那些不变化的代码写在一起。<br>
 &nbsp;&nbsp;&nbsp;2:针对接口编程，而不是针对实现编程。<br>
 &nbsp;&nbsp;&nbsp;3:多用组合，少用继承。
##故事
鸭子的故事：<br>
&nbsp;&nbsp;&nbsp;小强（程序员）所在的公司刚接手了一个项目：“模拟鸭子应用系统”:该系统中会游泳（正常游泳），会叫（呱呱叫）
,老大见小强平时挺闲的，说小强同学，这个项目就由你一个人负责吧，好好干，到年底年终奖给你多发点，小强（好开心）就接下了这个项目。
<br>
&nbsp;&nbsp;&nbsp;小强虽然不是一个老手，但也不是当初那个新人了，他深深的体会过客户万变的需求，所以他没有
一上来就开始写代码去实现怎么叫，怎么游泳。于是乎他开始构思整个项目的架构写了第一版代码(version1)。<br>
&nbsp;&nbsp;&nbsp;在version1中，小强是这样想的既然所有的鸭子都会游泳，和叫的属性那么先写一个父类来描述这种
飞，叫的行为，于是乎SuperDuck类就出来了，然后不同的类型的子类来继承这个父类。可以看到在第一版中可以实现客户的
基本需求。<br>
&nbsp;&nbsp;&nbsp;好景不长，客户那边说,ＭallardDuck这个鸭子不想让他飞了，mmp这不是搞事情吗，好吧，既然这样的话，那我就在
MallardDuck 类里面重写一下这个Fly方法就行了，等等，好像哪里不对，万一明天他又和我说来了ｎ多个鸭子，都是不会飞的，那我岂
不是需要在ｎ多个鸭子里都重写fly方法，这tmd可是要死人的呀，显然用以前的这种架构是不太好的方式。<br>
&nbsp;&nbsp;&nbsp;如果使用接口呢？我把飞的这个行为抽出来写一个接口呢，这样的话，用一个会飞类，和不会飞的类去实现该接口
会不会飞的行为，之后我在让SuperDuck类中去调用该行为方式，因为鸭子都需要有飞，和叫的行为，不如，我都交给SuperDuck，正在
此时，又接受到了一个新的需求说是有的RedHeadDuck鸭子的叫声要吱吱叫，正好，那我就再写一个接口把鸭子叫的行为也抽出来写一个接口就好了，
思路和飞的一样，目前客户说有三种叫，呱呱叫，吱吱叫，不会叫 ，于是就写了version2，这个代码从一定程度上克服了客户经常
变更需求的场景。
##总结
&nbsp;&nbsp;&nbsp;现在来回顾一下整个过程,由v1到v2，都经历了那些变换，连同策略模式的定义，和设计原则来看下整个过程的变换
实现,**首先接到了客户的需求变换是需要改变MallardDuck 由原来的会飞变成了不会飞，之后又让RedHeadDuck的叫由原来的呱呱叫变成了
吱吱叫，于是我们把他们都抽出来写成了接口，这正符合了我们的第一个设计原则**。
```
//叫行为
public interface QuackBehavior {
    /**
     * @return void
     * @Author zhangq
     * @Description //叫
     * @Date 下午10:26 2019/7/13
     * @Param []
     **/
    void quack();
}
//飞行为
public interface FlyBehavior {
    /**
     * @return void
     * @Author zhangq
     * @Description //飞
     * @Date 下午10:26 2019/7/13
     * @Param []
     **/
    void fly();
}
```
之后在SuperDuck类中添加了两个接口的使用
```
public abstract class SuperDuck {
    //叫行为
    QuackBehavior quackBehavior;
    //飞行为
    FlyBehavior flyBehavior;
  
```
并在SuperDuck类中定义方法performFly,performQuack委托给接口去调用对应的实现 从这里可以看出是针对
接口编程
```$xslt
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
```
之后并提供了行为的set方法，该方法的作用是为了防止客户说ＭallardDuck又再给我变回会飞的这种类似场景
````$xslt
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
````
最后看下测试代码
```$xslt
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

```
从整个代码结构来看，使用了接口，打个比方，比如MallardDuck这个鸭子想要飞，或不飞，可以随意组合，只需要调用setFlyBehavior(),
setQuackBehavior()设置对应的行为即可，以应对万变的需求,这正是多用组合，少用继承。<br>
&nbsp;&nbsp;&nbsp;因此在日常的开发中，当拿到需求后具体步骤如下：<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1:分析需求，确定可以设计几个类。<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2:分析会变化的行为方法，并把他们单独领出来，进行分装