package common;

/**
 * Java 运算符说明 <br/>
 * <b>注意: 负数如何转换为二进制: 原码(绝对值大小)的补码<b/>
 * 以 int(占用32为, 4 个字节) a = -5 为列:
 * 原码: 00000000 00000000 00000000 00000101
 * 补码:
 * <p>
 * <p>
 * 1: 二进制操作符: {@link JavaOperator}<br/>
 * &(与) :       只有两个位上面都是 1 才是 1，其他为 0  <===> 只有 1 + 1 = 1 , 其他为 0;{@link JavaOperator#show1(int, int)}<br/>
 * 或(|) :       只要为上有一个 1 就为 1               <===> 只有 0 + 0 = 0 , 其他为 1;{@link JavaOperator#show2(int, int)}<br/>
 * 异或(^):      只有两位数不同时才为 1                <===> 只有 0 + 0 或 1 + 1 等于 0 , 其他为 1; {@link JavaOperator#show3(int, int)}<br/>
 * 取反(~):      全部为1的变为 0，为 0 的为 1; {@link JavaOperator#show4()}<br/>
 * 向左移位(<<): 比如 5(101) << 1 , 5向左移动一位， 也就是 101(二进制) 整体向左移动一位，然后补 1 个 0; 也就是 1010（10）<===> 5*2的一次幂 = m*2的n次幂 {@link JavaOperator#show5(int)}; <br/>
 * 向右移位(>>): 如果该数(要移动的数)为正，则高位补0，若为负数，则高位补1;<br/>
 * &nbsp;比如 5(101) >> 1 , 5向右移动一位， 也就是 101(二进制) 整体向右移动一位，然后砍 1 位数; 也就是 10 (2)   <===>  5/2的一次幂 = m/2的n次幂(取整数) {@link JavaOperator#show6(int)}; <br/>
 * 无符号右移(>>>): 和 >> 类似，只不过无论该数是正负都直接补 高位补0; {@link JavaOperator#show7(int)}<br/>
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
     * 如果该数(要移动的数)为正，则高位补0，若为负数，则高位补1;
     * 比如 5(101) >> 1 5向右移动一位， 也就是 101(二进制) 整体向右移动一位，然后砍 1 位数; 也就是 10 (2)   <===>  5/2的一次幂 = m/2的n次幂(取整数)
     */
    void show6(int m1) {
        System.out.println("------------展示 向右移位(>>) 操作符用法--------------");
        System.out.println(Integer.toBinaryString(m1));
        System.out.println(m1 >> 1); //0010 值为2
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(-5 >> 1));
        System.out.println(-5 >> 1); // -3

    }

    /**
     * 展示 无符号右移(>>>) 操作符用法
     * <p>
     * 和 >> 类似，只不过无论该数是正负都直接补 高位补0;
     *
     * @param m1
     */
    void show7(int m1) {
        System.out.println("------------展示 无符号右移(>>>) 正数 操作符用法--------------");
        System.out.println(m1 >>> 1);
        System.out.println("------------展示 无符号右移(>>>) 负数 操作符用法--------------");
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(-5 >>> 1));
        System.out.println(-5 >>> 1);

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
        operator.show6(m1);
        operator.show7(m1);
    }
}
