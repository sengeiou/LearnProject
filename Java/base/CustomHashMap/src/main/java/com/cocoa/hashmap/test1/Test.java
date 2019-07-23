package com.cocoa.hashmap.test1;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * HashMap 深度研究
 * 本文基于  JDK 1.8.0_131-b11 编写， 与别的版本可能有出入，请仔细查看源码和注释
 * <p>
 * <p>
 * 参考：本文的参考文章地址
 * https://zhuanlan.zhihu.com/p/26831284
 * http://www.importnew.com/7099.html
 * http://blog.csdn.net/anxpp/article/details/51234835
 */
public class Test {


    private String name;
    private int age;

    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {

        String o = "123";
        String o1 = "223";
        int o2 = 223;
        boolean o3 = true;
        boolean o4 = false;

        //    Objects.hashCode(o)  == o.hashCode()  本质上是一样的 不过o必须重写了 hashCode  方法
        System.out.println(Objects.hashCode(o));
        System.out.println(o.hashCode());


        HashMap hashMap = new HashMap();
        hashMap.put(null, 1);
        hashMap.put(null, 2);
        hashMap.put(null, 3);
        // hashMap 是可以用null 作为 key 的。 但是多次使用后，会被覆盖
        System.out.println("hashmap get null" + hashMap.get(null));


        System.out.println(Objects.hashCode(o));
        System.out.println(Objects.hashCode(o1));
        System.out.println(Objects.hashCode(o2));
        System.out.println(Objects.hashCode(o3));
        System.out.println(Objects.hashCode(o4));
        System.out.println(Objects.hashCode(new Test("--", 12)));


        // 下面这个例子很奇怪， Test 并没有重写 hashCode 但是调用Objects.hashCode 竟然能算出hashCode
        // 而且 Test 类能直接做HashMap 的key 使用，有点奇怪
        Test t = new Test("t", 12);
        Test t1 = new Test("t1", 11);

        HashMap<Test, String> tHashMap = new HashMap<>();
        tHashMap.put(t, "t");
        tHashMap.put(t1, "t1");

        System.out.println(Objects.hashCode(t));
        System.out.println(Objects.hashCode(t1));

        System.out.println(tHashMap.get(t));
        System.out.println(tHashMap.get(t1));

        // 终于能对上面的一半做出解释了， get方法一定是对对象的地址进行了判断，判断为同一个对象时，就取出对应的Node
        // 这就是为什么同一个对象的存取，是正常的，即使没有重写 equals 和 hashCode
        // 还有一点，猜测，如果自定义的对象如果不重写hashCode , 用Object 的 hashCode 算法，则会出现很高的碰撞率
        // 重写 equals 和 hashCode 的方法， 见本文最下端
        System.out.println(tHashMap.get(new Test("t", 12)));  // 取出的是null

        // 反射获取 Node 数组 ，好像没什么用
        HashMap<Integer, Integer> intHashMap = new HashMap<>();
        for (int i = 0; i < 50; i++) {
            intHashMap.put(i, i);
        }
        Class clazz = HashMap.class;

        Field field = null;
        try {
            field = clazz.getDeclaredField("table");
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        try {
            Object aaa = field.get(intHashMap);
            HashMap.Entry[] en = (HashMap.Entry[]) aaa;
            System.out.println(en.length);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println(e);
        }


        // Hash 的底层是有数组 和 链表组成 ，将存储的key 获取 hashCode ，然后取模。  得到  i = hashCode % 数组长度
        // 就将改 key 对应存储在对应的 数组的i 位置，如果i 位置有值，那么就存放在 i 位置的 链表的下一个元素
        // 由于取模操作对计算机来说执行消耗很大（猜测），官方用了与运算符来优化，（但是的时间维度对比，发现并没有速度的提升，可能我的方法不对）
        // 具体的算法是 i = hashCode & (arrayLength - 1)
        // 但是与运算符 也有它的缺点，就是 arrayLength 必须是2 的 幂 比如   16 32 64 128
        //  默认的数组大小是16，然后用 oldCap << 1 来扩容 16 << 1  = 32 ,所以 hashMap的 数组长度也是2的幂
        // 转成二进制后，发现15 == 1111 ； 31 ==11111 ； 63 == 111111 ； 127 =1111111
        //  128 & (16-1)   ==  1000 0000 & 0000 1111  == 0000 0000 = 0
        //  66 & (16-1)   ==  0100 0010 & 0000 1111  == 0000 0010  = 2
        //        http://tool.lu/hexconvert/


        long time = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 50000000; i++) {
            int aa = 100 % 16;
        }
        System.out.println(System.currentTimeMillis());


        time = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 50000000; i++) {
            int aa = 100 & (16 - 1);
        }
        System.out.println(System.currentTimeMillis());

        // 来看具体的缺点  随便用个数字，不是2 的 幂
        // 如果 i = hashCode & (15 - 1)   用 0- 65 去计算
        // 发现 取出的值是 0 2 4 6 8 10 12 14  而不是我们想要的0-14
        // 这样的算法就大大增加了碰撞的几率，会直接影响 hashMap 的获取效率

        for (int i = 0; i < 65; i++) {
            System.out.println("---" + (i & (15 - 1)));
        }
        // 而取模操作则不会出现上述的情况
        for (int i = 0; i < 65; i++) {
            System.out.println("---" + (i % 15));
        }


        // 首先来看下  hashmap 的初始化
//        public HashMap(int initialCapacity, float loadFactor) {
//            if (initialCapacity < 0)
//                throw new IllegalArgumentException("Illegal initial capacity: " +
//                        initialCapacity);
//            if (initialCapacity > MAXIMUM_CAPACITY)
//                initialCapacity = MAXIMUM_CAPACITY;
//            if (loadFactor <= 0 || Float.isNaN(loadFactor))
//                throw new IllegalArgumentException("Illegal load factor: " +
//                        loadFactor);
//            this.loadFactor = loadFactor;
//            this.threshold = tableSizeFor(initialCapacity);
//        }


        // 并没有什么特别的，其中最主要的方法是tableSizeFor
        // 下面来看tableSizeFor
        // 这个方法会 在构造方法 HashMap(int initialCapacity, float loadFactor) 时调用，用来手动设置 数组长度和负载因子
        // 因为上面讲到了initialCapacity 长度必须是2的整数幂 ，那万一有人传错了，比如传了个15 进来，
        // tableSizeFor 的作用就来了，返回一个大于或等于cap的最小的2的N次幂
        // 有点拗口，比如 cap =16 则返回16  cap =17 则返回32  cap =66 则返回128  ，大致应该懂意思了吧
        // 下面来看这个方法的实现   以 cap = 17 为例
        // 看下面 tableSizeFor 的方法注释
        // 这几次的 或操作 加 无符号右移的操作，使得N 在最后一定变成全为1
        // 然后  11111 + 00001   就一定是 100000  ，称为2的N次幂
        // 换言之 你传入的 cap 决定了位数X，然后或操作加无符号右移的操作，使得这个X为数字全部成为1 。最后加1，就OK 了
        // 比如  17 = 10001 什么都不管，先变成=> 11111 再加 00001
        // 位操作简直太神奇了，至于10001 会变成 11111 的原理，还没搞太明白

        tableSizeFor(17);
        System.out.println(31 >>> 8);


        int result = 32 & (32 + 1);
        System.out.println(result);

        //  接着看，还有个神奇的方法， hash（Object key）
        String testHashStr = "123";
        // 以 string 为例， 调用 string 的 hashCode 和 用 hash 方法 ，发现结果是一样的
        System.out.println("hashCode()===>" + testHashStr.hashCode());
        System.out.println("hash(Object key)===>" + hash(testHashStr));


//        static final int hash(Object key) {
//            int h;
//            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//        }

        // 很奇怪 ，为什么结果是一样， 为什么 hash 方法还要多此一举呢
        // 参考： http://blog.csdn.net/anxpp/article/details/51234835
        // 首先我们来看 hash 方法的注释
        // 大致翻译就是：
/**
 * Computes key.hashCode() and spreads (XORs) higher bits of hash
 * to lower.  Because the table uses power-of-two masking, sets of
 * hashes that vary only in bits above the current mask will
 * always collide. (Among known examples are sets of Float keys
 * holding consecutive whole numbers in small tables.)  So we
 * apply a transform that spreads the impact of higher bits
 * downward. There is a tradeoff between speed, utility, and
 * quality of bit-spreading. Because many common sets of hashes
 * are already reasonably distributed (so don't benefit from
 * spreading), and because we use trees to handle large sets of
 * collisions in bins, we just XOR some shifted bits in the
 * cheapest possible way to reduce systematic lossage, as well as
 * to incorporate impact of the highest bits that would otherwise
 * never be used in index calculations because of table bounds.
 */
        // 然后直接从代码角度理解，向右移动16 位 ，其实就是 小于 2的16次方的数， 都会变成 0
        //  65536 == 10000000000000000  向右移16位 空位用 0 补齐，正好是1
        System.out.println(65536 >>> 16);  // ->   1

        // 再用 异或运算符  （两个操作数的位中，相同则结果为0，不同则结果为1。）
        // 比如 199 = 11000111   11000111 ^ 00000000  那么得到的一定是它的本身
        // 这就解释了 testHashStr 为什么用两种方法得到的都是一样的结果
        // 换言之，只要对象的hashCode不大于 65536 （2的16次方） ，那么 hash（） == hashcode()

        // 接着来看，万一hashCode 大于 65536 呢？

        System.out.println((65537 >>> 16) ^ 65537);// ->   65536
        System.out.println((100000 >>> 16) ^ 100000);// ->   100001
        System.out.println((99999 >>> 16) ^ 99999);// ->   99998

        // 发现什么规律了没？ 好像都是元数的 +1 或 -1
        // 其实最神奇的就是下面这个测试
        System.out.println("----------");
        for (int i = 0; i < 20; i++) {
            int a = i << 16;
//            a = (a >>> 16) ^ a;   // 打开这行看下，输出是0 -15 ，关闭这行，则输出全是0
            System.out.println(a + "----" + (a & (16 - 1)));
        }

        // 到此为止，全都明白了， 当 hash 值大于65536 的情况下，用 (hash & (arraySize - 1) 方法取模， 则会出现很大几率的碰撞
        // 上面这个循环就是很好的例子，全部 输出为0
        // 为什么 hash 值大于65536 ，就会出现这么糟糕的情况呢？


//---------------------------------------------

//        HashMap 构造方法
//
//        public HashMap(int initialCapacity, float loadFactor) {
//            if (initialCapacity < 0)
//                throw new IllegalArgumentException("Illegal initial capacity: " +
//                        initialCapacity);
//            if (initialCapacity > MAXIMUM_CAPACITY)
//                initialCapacity = MAXIMUM_CAPACITY;
//            if (loadFactor <= 0 || Float.isNaN(loadFactor))
//                throw new IllegalArgumentException("Illegal load factor: " +
//                        loadFactor);
//            this.loadFactor = loadFactor;    //负载因子，默认为0.75
//            this.threshold = tableSizeFor(initialCapacity);  // 取模数组长度，可能为0 ，默认为16
//        }

//---------------------------------------------
//        /**
//         * Implements Map.putAll and Map constructor   就是在putAll(evict = true)， 构造hashMap， clone 时，会调用这个方法
//         * 可以认为是通过一个map ，构造一个hashMap
//         * @param m the map
//         * @param evict false when initially constructing this map, else    暂时没看动，跳过
//         * true (relayed to method afterNodeInsertion).
//         */
//        final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
//            int s = m.size();
//            if (s > 0) {   不用自己去判断
//                if (table == null) { // pre-size
//                    //数组还没初始化，就根据m 的长度 和负载因子去计算，这里可以看出，负载因子小于1，则  threshold 越大
//                    float ft = ((float)s / loadFactor) + 1.0F;
//                    int t = ((ft < (float)MAXIMUM_CAPACITY) ?
//                            (int)ft : MAXIMUM_CAPACITY);
//                    if (t > threshold)
//                        threshold = tableSizeFor(t);
//                }
//                else if (s > threshold)   // 这里没看懂，为什么是拿 size 和 threshold 比
//                    resize();             // 重新计算 当前 hashmap 的参数，后续在看
//                for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {   // 循环添加
//                    K key = e.getKey();
//                    V value = e.getValue();
//                    putVal(hash(key), key, value, false, evict);   //** 很重要，后期看
//                }
//            }
//        }


        // for test
        HashMap<String, String> map1 = new HashMap<>(16,0.5F);  // 很奇怪，我以为 算出的threshold 会是64，没想到还是32
        HashMap<String, String> map2 = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map1.put(i+"",""+i);
            map2.put(i+"",""+i);
        }
        map1.putAll(map2);


//---------------------------------------------





    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;  //16
        n |= n >>> 1;    // 16 | 16 >>> 1 =  10000 | 01000  = 11000 =   24
        n |= n >>> 2;    // 24 | 24 >>> 2 =  11000 | 01100  = 11110 = 30
        n |= n >>> 4;    // 30 | 30 >>> 4 =  11110 | 00001  = 11111 = 31
        n |= n >>> 8;    // 31 | 31 >>> 8 =  11111 | 00000  = 31
        n |= n >>> 16;   // 31 | 31 >>> 16 =  11111 | 00000  = 31
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


/**
 自定义对象重写 equals 和 hashCode 的例子 ，这是netty 的源码XmlAttribute
 重写  hashCode  的方法 ： 对于对象中每个关键域f，为该域计算int类型的散列码c，result = 31 * result + c

 private final String type;
 private final String name;
 private final String prefix;
 private final String namespace;
 private final String value;


 @Override public boolean equals(Object o) {
 if (this == o) { return true; }
 if (o == null || getClass() != o.getClass()) { return false; }

 XmlAttribute that = (XmlAttribute) o;

 if (!name.equals(that.name)) { return false; }
 if (namespace != null ? !namespace.equals(that.namespace) : that.namespace != null) { return false; }
 if (prefix != null ? !prefix.equals(that.prefix) : that.prefix != null) { return false; }
 if (type != null ? !type.equals(that.type) : that.type != null) { return false; }
 if (value != null ? !value.equals(that.value) : that.value != null) { return false; }

 return true;
 }

 /**
 答： 2 << 3（左移3位相当于乘以2的3次方，右移3位相当于除以2的3次方）。

 补充：我们为编写的类重写hashCode方法时，
 可能会看到如下所示的代码，
 其实我们不太理解为什么要使用这样的乘法运算来产生哈希码（散列码），
 而且为什么这个数是个素数，为什么通常选择31这个数？
 前两个问题的答案你可以自己百度一下，选择31是因为可以用移位和减法运算来代替乘法，
 从而得到更好的性能。说到这里你可能已经想到了：31 * num 等价于(num << 5) – num，
 左移5位相当于乘以2的5次方再减去自身就相当于乘以31，现在的VM都能自动完成这个优化。


 @Override public int hashCode() {
 int result = type != null ? type.hashCode() : 0;
 result = 31 * result + name.hashCode();
 result = 31 * result + (prefix != null ? prefix.hashCode() : 0);
 result = 31 * result + (namespace != null ? namespace.hashCode() : 0);
 result = 31 * result + (value != null ? value.hashCode() : 0);
 return result;
 }

 **/
}
