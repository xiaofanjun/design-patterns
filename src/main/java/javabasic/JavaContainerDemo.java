package javabasic;


import java.util.*;

/**
 * {@code JavaContainerDemo} Java 容器模块
 * <p>
 * 1: Java 容器有那些 ? <br/>
 * Java 容器分为Collection 和 Map 两大类 ，其下又有很多子类，如下所示 : <br/>
 * &nbsp; Collection (接口){@link java.util.Collection}, 子接口如下  : <br/>
 * &nbsp;&nbsp; List(接口) {@link java.util.List} --->(实现类) ArrayList{@link java.util.ArrayList},LinkedList{@link java.util.LinkedList}，Vector(类){@link java.util.Vector} --->(子类),Stack{@link java.util.Stack}  <br/>
 * &nbsp;&nbsp; Set(接口){@link java.util.Set}    --->(实现类) HashSet{@link java.util.HashSet},LinkedHashSet{@link java.util.LinkedHashSet},TreeSet{@link java.util.LinkedHashSet}<br/>
 * &nbsp; Map（接口）{@link java.util.Map} ,实现类如下: <br/>
 * &nbsp;&nbsp; HashMap{@link java.util.HashMap} --->(继承类) LinkedHashMap{@link java.util.LinkedHashMap} <br/>
 * &nbsp;&nbsp; TreeMap{@link java.util.TreeMap} <br/>
 * &nbsp;&nbsp; ConcurrentHashMap{@link java.util.concurrent.ConcurrentHashMap} <br/>
 * &nbsp;&nbsp; Hashtable{@link java.util.Hashtable} <br/>
 * <p>
 * <p>
 * 2: Collection{@link java.util.Collection} 和 Collections{@link java.util.Collections} 有什么区别 ? <br/>
 * Collection 是一个集合接口，它提供了对集合对象进行基本操作的通用接口方法，所有集合都是它的子类，比如 List、Set 等 <br/>
 * Collections 是一个包装类，包含了很多静态方法，不能被实例化，就像一个工具类，比如提供的排序方法：Collections. sort(list) <br/>
 * <p>
 * <p>
 * 3: List,Set,Map 之间的区别是什么 ? {@link JavaContainerDemo3}<br/>
 * 主要区别在于两个方面 : 元素是否排序，是否允许元素重复 <br/>
 * 排序:    List 不排序 ; HashSet 可排序; HashMap 可排序(按照 key 排序){@link JavaContainerDemo3#show1()}<br/>
 * 元素重复: List 不去重 ; HashSet 去重; HashMap 去重(key 不能重复),value 可重复。{@link JavaContainerDemo3#show2()}<br/>
 * <b>总结: List 即不排序，也不去重 ; HashSet ,HashMap,即去重也排序，只不过 HashMap 是针对 key 值来说的</b>
 * <p>
 * <p>
 * 4: HashMap 和 HashTable 区别 ? <br/>
 * (1) 从代码架构上说: <br/>
 * HashMap{@link HashMap} 继承自 AbstractMap{@link AbstractMap} ，而 HashTable{@link Hashtable} 继承自Dictionary{@link Dictionary} 类;不过都实现了 Map,Cloneable(可复制),Serializable(可序列化) 这三个接口。<br/>
 * (2) 从功能方面说: <br/>
 * HashMap 中的 key-value 支持 key-value , null-null , key-null, null-value 四种形式, 而HashTable 只支持 key-value 这一种形式.<br/>
 * 所以说: 当判断HashMap 中某个key是否存在时，不能使用 get() 方法取判断，因为当你的key=null时，返回的也是null，所以应该使用containsKey() 方法去判断.<br/>
 * (3) 从线程安全说: <br/>
 * HashMap : 非线程安全(没有被synchronized) , HashTable : 线程安全(方法几乎被synchronized修饰)<br/>
 * 但是如果需要HashMap 是线程安全是怎么处理呢? <br/>
 * &nbsp;（3.1）可以使用 Collections.synchronizedMap(hashMap){@link Collections#synchronizedMap(java.util.Map)} 来进行处理 .<br/>
 * &nbsp; (3.2) 也可以使用ConcurrentHashMap{@link java.util.concurrent.ConcurrentHashMap} , 它比HashTable 效率高好多倍，因为该类使用的是分段锁，并不对整个数据进行锁定。<br/>
 * <b>总结: 对于HashMap 和 HashTable 的使用，应尽量使用HashMap，因为无论是否需要线程安全（需要线程安全时可以使用上面两种方式保持），HashMap都要 比 HashTable 效率高</b>
 * (4) 从容量初始化说: <br/>
 * 初始化容量，每次扩容大小 两个都不一样: HashMap 默认初始化 = 16 ，之后每次扩容为原来的 2 倍 ; HashTable 默认初始化 = 11 ，之后每次扩容为原来的 2n+1;<br/>
 * 计算hash值不一样: {@link JavaContainerDemo4_4}<br/>
 * HashMap :  为了得到元素的位置，首先需要根据元素的key计算出一个 hash 值，然后再用这个 hash 值来计算得到最终位置 {@link JavaContainerDemo4_4#show1()}<br/>
 * HashTable: 直接使用对象的 hashCode，hashCode 是 JDK 根据对象的地址或者字符串或者数字计算出来的 int 类型的数值，然后再使用保留余数获取最终的位置.{@link JavaContainerDemo4_4#show2()}<br/>
 */
public class JavaContainerDemo {
}

class JavaContainerDemo3 {
    /**
     * 测试 是否排序
     * <p>
     * 运行结果:
     * ArrayList = [a, c, b]
     * HashSet = [a, b, c]
     * HashMap = {a=1, b=2, c=3}
     */
    void show1() {
        System.out.println("-------------------测试是否排序---------------------");
        List arrayList = new ArrayList();
        Set hashSet = new HashSet();
        Map hashMap = new HashMap();
        arrayList.add("a");
        arrayList.add("c");
        arrayList.add("b");
        System.out.println("ArrayList = " + arrayList);
        hashSet.add("a");
        hashSet.add("c");
        hashSet.add("b");
        System.out.println("HashSet = " + hashSet);
        hashMap.put("a", "1");
        hashMap.put("c", "3");
        hashMap.put("b", "2");
        System.out.println("HashMap = " + hashMap);

    }

    /**
     * 测试 元素是否可以重复
     * <p>
     * 运行结果：
     * ArrayList = [a, a, b]
     * HashSet = [a, b]
     * HashMap = {a=1, b=2}
     */
    void show2() {
        System.out.println("-------------------测试是否重复---------------------");
        List arrayList = new ArrayList();
        Set hashSet = new HashSet();
        Map hashMap = new HashMap();
        arrayList.add("a");
        arrayList.add("a");
        arrayList.add("b");
        System.out.println("ArrayList = " + arrayList);
        hashSet.add("a");
        hashSet.add("a");
        hashSet.add("b");
        System.out.println("HashSet = " + hashSet);
        hashMap.put("a", "1");
        hashMap.put("a", "1");
        hashMap.put("b", "2");
        System.out.println("HashMap = " + hashMap);
    }


    public static void main(String[] args) {
        JavaContainerDemo3 demo3 = new JavaContainerDemo3();
        demo3.show1();
        demo3.show2();
    }
}

class JavaContainerDemo4_4 {
    /**
     * 展示 HashMap 计算 hash 值的方式
     * <p>
     * 为了得到元素的位置，首先需要根据元素的key计算出一个 hash 值，然后再用这个 hash 值来计算得到最终位置
     * <p>
     * HashMap 中的 hash方法{@link HashMap#hash(java.lang.Object)} 逻辑如下:
     * int h;
     * return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
     * 可以看出 当key为null时，hash = 0 ;
     * 否则 hash = (h = key.hashCode()) ^ (h >>> 16);
     * 这里对 ^ {@link common.JavaOperator#show3(int, int)}和 >>> {@link common.JavaOperator#show7(int)} 操作符 说明一下: 都是二进制运算符
     */
    void show1() {
        System.out.println("-------------------展示 HashMap 计算 hash 值的方式------------------");
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("a", "1");
        System.out.println(hashMap.hashCode());
    }

    /**
     * 展示 HashTable 计算 hash 值的方式
     * <p>
     * 直接使用对象的 hashCode，hashCode 是 JDK 根据对象的地址或者字符串或者数字计算出来的 int 类型的数值，然后再使用保留余数获取最终的位置
     */
    void show2() {
        System.out.println("-------------------展示 HashTable 计算 hash 值的方式------------------");
    }

    /**
     * 展示 HashMap 的 hashCode 方法实现原理 {@link HashMap#hashCode()}
     */
    void show3() {

    }

    public static void main(String[] args) {
        JavaContainerDemo4_4 demo4_4 = new JavaContainerDemo4_4();
        demo4_4.show1();
        demo4_4.show2();
    }
}
