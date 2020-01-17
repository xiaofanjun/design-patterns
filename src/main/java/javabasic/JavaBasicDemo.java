package javabasic;

import utils.JavaUtils;

import java.io.InputStream;

/**
 * {@code JavaBasicDemo} Java基础相关
 * <p>
 * 1:JDK 和 JRE 有什么区别 ?</br>
 * JDK:Java Development Kit(java 开发工具包) 的简称，提供了Java的开发环境和运行环境；</br>
 * JRE:Java Runtime Environment(Java 运行时环境) 的简称，为Java的运行提供了所需的环境；</br>
 * 具体来说JDK其实包含了JRE，同时还包含了编译Java的编译器Javac，还包含了程序调试和分析的工具；</br>
 * 简单来说：如要只是要运行java程序，装个jre就好使(客户);如果要是编写代码，就装个JDK.（程序员）</br>
 * <b>总结： 能用jdk用jdk，因为jdk比较全</b>
 * <p>
 * <p>
 * 2: == 和 equals 的区别是什么 ? {@link JavaBasicDemo2}</br>
 * == : 对于基本数据类型比较的是 值 是否相同(8种基本类型)； 对于引用类型，比较的是引用是否相同；{@link JavaBasicDemo2#show1()}<br/>
 * equals : 本质上(Object)是 == ，只不过是 String，Integer 等重写了equals方法，把他变成了值比较；{@link JavaBasicDemo2#show2()}<br/>
 * <b>总结： 对于8中基本类型，只能用==；  如果 非8基本类型 && 非Object(重写了Object的equals()) 比较引用 用 == ，比较值用 equals</b>
 * <p>
 * <p>
 * 3: 两个对象的hashCode() 相同，那么equals()也一定为true，对吗 ? {@link JavaBasicDemo3}；<br/>
 * 不对，两个对象的hashCode（）相同，equals（） 不一定为true;
 * 原因： 以String对象为列 其hashCode值的计算公式为： s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1] , s[] 为String对象的char数组<br/>
 * 所以可以得出，如果两个对象的值一样，那么得到的hashCode值是一样的，也就是 equals 为 true ，hashCode 为true;
 * <b>总结： 两个对象 equals() 相同，hashCode()相同; hashCode()相同，equals() 不一定相同 {@link JavaBasicDemo3#show1()}</b>
 * <p>
 * <p>
 * 4: final 在Java中有什么作用 ?<br/>
 * final 修改的类叫最终类，该类不能被继承;<br/>
 * final 修改的方法不能被重写;<br/>
 * final 修饰的变量叫 常量，常量必须被初始化，初始化之后就不能被修改;<br/>
 * <p>
 * <p>
 * 5: Java 中的 Math.round(-1.5) 等于多少 ?<br/>
 * 等于 -1 ，round() 是四舍五入函数，需要注意的是负数5是舍的，例如：　Math.round(1.5)的值是2，而 Math.round(-1.5) 是 -1;<br/>
 * 这块把这个拿出来就是因为是负数的情况，比较特殊，用的时候注意下就好。
 * 6: String 属于基本数据类型吗 ? <br/>
 * 不属于，基本数据类型请看{@link JavaBasicDemo2#show1()} 中有举例，String 属于是对象。<br/>
 * <p>
 * <p>
 * 7: Java 中的操作字符串都有那些类? 它们之间有什么区别 ? <br/>
 * （这个问题问的比较巧）有 String , StringBuffer , StringBuilder ;<br/>
 * 从对象是否可变比较：<br/>
 * String 声明的是不可变的对象 {@link String#value} 是 final类型的，这个value用来存放字符串,所以每次操作都会生成新对象<br/>
 * StringBuffer{@link StringBuffer#StringBuffer()},和 StringBuilder{@link StringBuilder#StringBuilder()} 都继承 AbstractStringBuilder {@link AbstractStringBuilder#value}，两个类对应的构造方法都是调用父类的<br/>
 * 并且在父类中存储数据的数组 char[] value 不适用final修饰的，所以对象是可变的。value 长度默认为16；当发现长度不够时，会自动扩容，扩展为原来长度的2倍+2{@link AbstractStringBuilder#newCapacity(int)}<br/>
 * 从线程安全性比较：<br/>
 * StringBuffer 很多方法都被 synchronized修饰了，如：{@link StringBuffer#append(java.lang.AbstractStringBuilder)} ，所以是线程安全的，但是效率就比较低了;StringBuilder 正好相反，效率高了，但是线程不安全；<br/>
 * <b>总结： 执行效率（高-->低）: StringBuilder ---> StringBuffer ---> String; 所以在日常开发中，应尽量少用String，以提高程序效率。</b>
 * <p>
 * <p>
 * 8: String str = "i" 和 String str = new String("i") 一样吗 ? <br/>
 * 不一样; 内存分配方式不一样。<br/>
 * String str = "i" 是向常量池中创建一个常量，有就返回该常量地址，没有就创建一个常量,所以这个{@link JavaBasicDemo2#show1()}方法中的st1==st2 结果为true就是这个原因。<br/>
 * String str = new String("i") 每次 new时都会向堆内存中开辟一块空间。<br/>
 * 所以：对于第一种方式，将会在常量池中存放一个常量 i 并返回str地址比如是  xx001; 对于第二种方式，就会在堆内存中创建一个对象 值 存为 i ，并返回地址，比如说是 xx111;<br/>
 * <p>
 * <p>
 * 9: 如何将字符串反转 ?<br/>
 * 使用StringBuilder 或者 StringBuffer 的 reverse() 方法； （日常知道就好）<br/>
 * <p>
 * <p>
 * 10: 抽象类必须有抽象方法吗 ?<br/>
 * 不必须，抽象类不一定非要有抽象方法，但一个抽象方法一定是一个抽象类{@link JavaBasicDemo10} （规定，记住就好）<br/>
 * <p>
 * <p>
 * 11: 普通类和抽象类有何区别 ?<br/>
 * 普通类不能有抽象方法，但 抽象类可以有;<br/>
 * 普通类可以直接实例化，但 抽象类不能; <br/>
 * 普通类继承抽象类，必须实现其抽象方法，如果不实现需也定义成抽象方法;<br/>
 * <p>
 * <p>
 * 12: 抽象类能被final修饰吗 ?<br/>
 * 不能; 定义抽象类，就是让其他类继承的，如果用 final修饰后，那么就不能被其他类继承，违反 抽象类 出现的意义，同时编辑器也会报错;<br/>
 * <p>
 * <p>
 * 13: 接口和抽象类有和区别 ?<br/>
 * 实现:       抽象类用 extends ，接口用 implements ;<br/>
 * 构造函数:   抽象类可以有，接口不能有 ;<br/>
 * 实现数量:   一个类只能继承一个抽象类，但可以实现多个接口 ;<br/>
 * 访问修饰符: 抽象类不能被修饰成private，（因为要被继承）,接口默认是public的。<br/>
 * <p>
 * <p>
 * 14: Java 中的 IO 流分为几种 ? <br/>
 * 功能: 输入流(input),输出流（output）;<br/>
 * 类型: 字节流 {@link InputStream} 处理字节或二进制对象，字符流{@link java.io.Reader} 处理字符或字符串 ; <br/>
 * 字节流和字符流的区别: 字节流是以 8 位为单位来input，output数据的，字符流是以 16 位 来input,output 数据的。<br/>
 * <b>总结: 关于流的使用，应该结合具体的使用场景来使用就好 </b>
 * <p>
 * <p>
 * 15: BIO,NIO,AIO 有什么区别 ? <br/>
 * BIO: Block IO 同步阻塞式 IO , 就是我们平常使用过的传统IO，优点: 简单使用方便; 缺点: 并发处理能力低 ;<br/>
 * &nbsp;比如以前的ServerSocket 就是基于这种方式的,在高并发场景下不适用。<br/>
 * &nbsp;y一个连接一个线程 ; Client如果有连接请求时，Server就需要有起一个线程来处理,如果连接不做啥事也会起着。<br/>
 * NIO: New IO 同步非阻塞 IO , 是传统IO(BIO) 的升级版，Client和Server 通过 Channel(通道) 通讯，实现了多路复用 ;<br/>
 * &nbsp;服务器实现模式为一个请求一个线程，即客户端发送的连接请求都会注册到多路复用器上，多路复用器轮询到连接有I/O请求时才启动一个线程进行处理;<br/>
 * AIO: Asynchronous IO 是NIO的升级版， 也叫 NIO2，实现了 异步非堵塞IO，异步IO的操作基于事件和回调机制 ;<br/>
 * &nbsp;服务器实现模式为一个有效请求一个线程，客户端的I/O请求都是由OS先完成了再通知服务器应用去启动线程进行处理<br/>
 *
 * @author xfj
 */
public class JavaBasicDemo {
}

class JavaBasicDemo2 {
    /**
     * 验证 ==
     * <p>
     * 该例子还展示了java的8种基本类型
     * 如： 8位 表示（就是二进制中有多少位）： 00000001
     *
     * <b>st1==st2 为true ; 是因为 st1的引用等于st2的引用，因为两个引用都存放的是常量池中该值的地址<b/>
     */
    void show1() {
        boolean bo1 = false, bo2 = false;// 1位

        byte b1 = 'b', b2 = 'b', b3 = 1;// 8位,最大存储255,用单引号或数字整数赋值;

        char c1 = 'r', c2 = 'r';// 16位,存储 Unicode码，用单引号赋值;
        short sh1 = 1, sh2 = 1, sh3 = '3';// 16位， 用单引号或者数字整数赋值；

        int a1 = 1, a2 = 1;// 32位，用数字整数赋值;
        float f1 = 1, f2 = 1, f3 = 1f, f4 = 1.0f;// 32位，结果可以保留小数,如果赋值时需要用小数，那么必须添加f;

        long lo1 = 1, lo2 = 1; // 64位
        double d1 = 1, d2 = 1, d3 = 1.00, d4 = 1f;//  64位,结果可以保留小数
        //输出结果都为true 对于 8 中基本类型
        System.out.println("--------------------==号比较8中基本类型----------------------");
        System.out.println(bo1 == bo2);
        System.out.println(b1 == b2);
        System.out.println(c1 == c2);
        System.out.println(sh1 == sh2);
        System.out.println(a1 == a2);
        System.out.println(f1 == f2);
        System.out.println(lo1 == lo2);
        System.out.println(d1 == d2);
        System.out.println("--------------------==号比较引用类型----------------------");
        //对于引用形类型
        String st1 = "hello xfj";
        String st2 = "hello xfj";
        String st3 = new String("hello xfj");
        String st4 = new String("hello xfj");
        System.out.println(st1 == st2);//这里为true 是因为 st1 的引用是常量池中的，并没有新建对象，所以st1 存放的引用和视是一样的
        System.out.println(st2 == st3);// false;
        System.out.println(st3 == st4);// false;

    }

    /**
     * 验证 equals
     */
    void show2() {
        System.out.println("--------------------验证 equals ---------------------");
        String st1 = new String("你好");
        String st2 = new String("你好");
        System.out.println(st1 == st2);//false; 在show1() 中已经证实
        System.out.println(st1.equals(st2));//true
    }

    public static void main(String[] args) {
        JavaBasicDemo2 demo2 = new JavaBasicDemo2();
        //demo2.show1();
        demo2.show2();
    }
}

class JavaBasicDemo3 {


    /**
     * 比较hashCode和equals
     * <p>
     * 通过查看String的hashCode() 函数源码得：
     * 以 String = "abc"; 为例
     * (1) : h = hash(这个值默认为0) --> h = 0;
     * (2) : char[] val = {'a','b','c'}; len = 3; 将循环3次，然后走公式  h = 31 * h + val[i];
     * (3) : h = var[0] 也就是 a 的UniCode值 为 97 第一次循环为 h = 97;
     * (4) : h = 31 * 97 + var[1](也就是 b的UniCode值 为98) h = 31 * 97 + 98 = 3105,第二次循环为 h = 3105;
     * (5) : h = 31 * 3195 + var[2](也就是c的UniCode值 为99) h = 31 * 3105 + 99 = 96354 第三次循环结束;
     * (6) : 循环结束，之后会 hash = h ,得 hash = 96354 ; 之后return 得出 abc 的 hashCode 为 96354
     * <p>
     * 通过以上可得hashCode是根据值对应的UniCode表中的值 + 算法（不同jdk版本可能不同）,那么如果可以找到两个不同的值，但是通过算法却得到hashCode一样的这样一个数，那么这个问题就解决了。
     * 通过查阅资料 UniCode表{@link JavaUtils#printUniCode(char)()}+ 自己相关计算得出： String str1 = "Ef" ; String str2 = "FG"; 时 两个hashCode 相同
     * 于是乎 我发现了一个规律 对于 字母来说  比如 ABC 来说  相等的hashcode---> Ab,BC;  BCD ---> Bc,CD; 以此类推 。
     * 最后再啰嗦一句 : 对于公式  h = 31 * h + val[i] ; 中 为啥参数是31 ,我的猜想应该是在开发String的时候，通过一定的推算，得出 31 可以比较可以让HashCode值不重复。
     */
    void show1() {
        String str1 = new String("aB");
        String str2 = new String("bc");
        System.out.println("str1的hashCode = " + str1.hashCode());
        System.out.println("str2的hashCode = " + str2.hashCode());
        System.out.println(str1.equals(str2));
    }

    public static void main(String[] args) {
        JavaBasicDemo3 demo3 = new JavaBasicDemo3();
        demo3.show1();
    }
}

abstract class JavaBasicDemo10 {
    void show1() {
        System.out.println("该抽象类中没有抽象方法");
    }
}