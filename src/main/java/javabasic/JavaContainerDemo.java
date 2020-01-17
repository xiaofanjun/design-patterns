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
 * &nbsp;&nbsp; HashMap{@link java.util.HashMap} --->(实现类) LinkedHashMap{@link java.util.LinkedHashMap} <br/>
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
 *
 *
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
