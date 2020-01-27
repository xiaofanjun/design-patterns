package common;

/**
 * Java 运算符说明 <br/>
 * 概念：<br/>
 * 1、原码：正数的二进制 <br/>
 * 2、反码：对原码取反 （1变0,0变1）<br/>
 * 3、补码：对反码+1 <br/>
 * <b> 这三个概念中都是对正数来说的,在计算机中可以看成没有负数!</b>
 * 那么，在二进制中负数是如何表示的呢 ？<br/>
 * 4、二进制中负数: 等同于上面的补码 （2的补码）
 * <p>
 * <p>
 * 1: 二进制操作符: {@link JavaOperator}<br/>
 * (1)、 &(与) :       只有两个位上面都是 1 才是 1，其他为 0  <===> 只有 1 + 1 = 1 , 其他为 0;{@link JavaOperator#show1(int, int)}<br/>
 * (2)、或(|) :       只要为上有一个 1 就为 1               <===> 只有 0 + 0 = 0 , 其他为 1;{@link JavaOperator#show2(int, int)}<br/>
 * (3)、 异或(^):      只有两位数不同时才为 1                <===> 只有 0 + 0 或 1 + 1 等于 0 , 其他为 1; {@link JavaOperator#show3(int, int)}<br/>
 * (4)、 取反(~):      全部为1的变为 0，为 0 的为 1; {@link JavaOperator#show4()}<br/>
 * (5)、 向左移位(<<):  比如 5(101) << 1 , 5向左移动一位， 也就是 101(二进制) 整体向左移动一位，然后补 1 个 0; <br/>
 * 也就是 1010（10）<===> 5*2的一次幂 = m*2的n次幂 {@link JavaOperator#show5(int)}; <br/>
 * (6)、 向右移位(>>): 如果该数(要移动的数)为正，则高位补0，若为负数，则高位补1;<br/>
 * &nbsp;比如 5(101) >> 1 , 5向右移动一位， 也就是 101(二进制) 整体向右移动一位，然后砍 1 位数; <br/>
 * 也就是 10 (2)   <===>  5/2的一次幂 = m/2的n次幂(取整数) {@link JavaOperator#show6()}; <br/>
 * (7)、 无符号右移(>>>): 和 >> 类似，只不过 >>> 会直接去掉移动的位数 ; {@link JavaOperator#show7(int)}<br/>
 */
public class JavaOperator {
    /**
     * 展示 &(与) 操作符用法
     * <p>
     * 只有两个位上面都是 1 才是 1，其他为 0
     */
    void show1(int m1, int m2) {
        System.out.println("------------展示 &(与) 操作符用法--------------");
        System.out.println(m1 & m2); //0100 值为4
    }

    /**
     * 展示 或(|) 操作符用法
     * <p>
     * 只要为上有一个 1 就为 1
     */
    void show2(int m1, int m2) {
        System.out.println("------------展示 或(|) 操作符用法--------------");
        System.out.println(m1 | m2); //1101 值为13
    }

    /**
     * 展示 异或(^) 操作符用法
     * <p>
     * 只有两位数不同时才为 1
     */
    void show3(int m1, int m2) {
        System.out.println("------------展示 异或(^) 操作符用法--------------");
        System.out.println(m1 ^ m2); //1001 值为9
    }

    /**
     * 展示 取反(~) 操作符用法
     * <p>
     * 全部为1的变为 0，为 0 的为 1
     */
    void show4() {
        System.out.println("------------展示 取反(~) 操作符用法--------------");
        System.out.println(~12);
        String binaryStr = java.lang.Integer.toBinaryString(~12);
        System.out.println("取反后的二进制为:" + binaryStr); //11111111111111111111111111110011
    }

    /**
     * 展示 向左移位(<<) 操作符用法
     * <p>
     * 比如 5(101) << 1 5向左移动一位， 也就是 101(二进制) 整体向左移动一位，然后补 1 个 0; 也就是 1010（10）<===> 5*2的一次幂 = m*2的n次幂
     */
    void show5(int m1) {
        System.out.println("------------展示 向左移位(<<) 操作符用法--------------");
        System.out.println(m1 << 1); //1010 值为10
    }

    /**
     * 展示 向右移位(>>) 操作符用法
     * <p>
     * 1: 举例： int a = 5; +5 >> 1;
     * (1)、5 转换为2进制为：    00000000 00000000 00000000 00000101 ;
     * (2)、然后向右移动1位得：  00000000 00000000 00000000 00000010 ;
     * 之后结果转换为十进制为 2的1次幂 = 2; (砍掉一位，然后左边补0)
     * 2：举例： int a = -5; -5 >>1 ;
     * (1)、-5 转换为2进制为：  11111111 11111111 11111111 11111011 ;
     * (2)、然后向右移动一位得: 11111111 11111111 11111111 11111101 ;
     * 之后结果转换为十进制为 -3; (砍掉一位，然后左边补1)
     * 总结：该操作
     */
    void show6() {
        System.out.println("------------展示 向右移位(>>) 操作符用法--------------");
        String s = Integer.toBinaryString(5);
        System.out.println("5(" + s + ") 右移(>>) 1 位，结果为 ：");
        System.out.println(5 >> 1);
        String s1 = Integer.toBinaryString(-5);
        System.out.println("-5(" + s1 + ") 右移(>>) 1 位，结果为 ：");
        System.out.println(-5 >> 1);
    }

    /**
     * 展示 无符号右移(>>>) 操作符用法
     * <p>
     * 直接把 移动掉的几位直接去掉即可
     * <p>
     * 1: 举例： int a = 5; +5 >>> 1;
     * (1)、5 转换为2进制为：    00000000 00000000 00000000 00000101 ;
     * (2)、然后向右移动1位得：  00000000 00000000 00000000 0000010 ;
     * 之后结果转换为十进制为 2的1次幂 = 2;  (直接把移动位数砍掉)
     * 2：举例  int a = -5; -5 >>> 1;
     * (1)、-5 转换为2进制为： 11111111 11111111 11111111 11111011 ;
     * (2)、然后向右移动1位：  11111111 11111111 11111111 1111101 ;
     * 之后结果转换为十进制为 2的32次幂+2的31次幂 + ... + 2的2次幂+2的0次幂 =  2147483645 (直接把移动位数砍掉)
     * 总结：对于右移来说右移的位数越多，得到的数越小 （对于移动位数来说）,但对于负数来说移动一位将是被移动数的最大值
     *
     * @param m1
     */
    void show7(int m1) {
        System.out.println("------------展示 无符号右移(>>>) 正数 操作符用法--------------");
        String s = Integer.toBinaryString(5);
        System.out.println("5(" + s + ") 无符号右移(>>>) 1 位，结果为 ：");
        System.out.println(5 >>> 3);
        String s1 = Integer.toBinaryString(-5);
        System.out.println("-5(" + s1 + ") 无符号右移(>>>) 1 位，结果为 ：");
        System.out.println(-5 >>> 31);

    }

    public static void main(String[] args) {
        int m1 = 5; // 0101
        int m2 = 12; // 1100
        JavaOperator operator = new JavaOperator();
        operator.show1(m1, m2);
        operator.show2(m1, m2);
        operator.show3(m1, m2);
        operator.show4();
        operator.show5(m1);
        operator.show6();
        operator.show7(m1);
    }
}
