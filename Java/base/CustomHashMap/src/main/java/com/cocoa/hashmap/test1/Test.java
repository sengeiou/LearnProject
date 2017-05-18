package com.cocoa.hashmap.test1;



import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by sj on 17/5/18.
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
        System.out.println(Objects.hashCode(new Test("--",12)));


        // 下面这个例子很奇怪， Test 并没有重写 hashCode 但是调用Objects.hashCode 竟然能算出hashCode
        // 而且 Test 类能直接做HashMap 的key 使用，有点奇怪
        Test t = new Test("t",12);
        Test t1 = new Test("t1",11);

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
        System.out.println(tHashMap.get(new Test("t",12)));  // 取出的是null

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
            System.out.println("---"+(i & (15-1)));
        }
        // 而取模操作则不会出现上述的情况
        for (int i = 0; i < 65; i++) {
            System.out.println("---"+(i %15));
        }

        // 下面来看tableSizeFor
        // 这个方法会 在构造方法 HashMap(int initialCapacity, float loadFactor) 时调用，用来手动设置 数组长度和负载因子
        // 因为上面讲到了initialCapacity 长度必须是2的整数幂 ，那玩意有人传错了，比如传了个15 进来，
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
        System.out.println(31>>>8);

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
 自定义对象重写 equals 和 hashCode 的例子 ，这是neetty 的源码XmlAttribute
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
