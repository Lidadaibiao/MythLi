package com.lidadaibiao.JUC;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Lidadaibiao
 * @date 2020/6/10 - 15:52
 * 注意list面试相关问题
 *1: ArrayList有用过吗？它是一个什么东西？可以用来干嘛？
 *   ArrayList就是数组列表，主要用来装载数据，
 *   当我们装载的是基本类型的数据int，long，boolean，short，byte…的时候我们只能存储他们对应的包装类，它的主要底层实现是数组Object[] elementData。
 *   >>ArrayList底层是用数组实现的存储。查询效率高，增删效率低，线程不安全。
 * 2:您说它的底层实现是数组，但是数组的大小是定长的，如果我们不断的往里面添加数据的话，不会有问题吗？
 *   ArrayList可以通过构造方法在初始化的时候指定底层数组的大小。
 *   通过无参构造方法的方式ArrayList()初始化，则赋值底层数Object[] elementData为一个默认空数组Object[]
 *   DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {}所以数组容量为0，只有真正对数据进行添加add时，才分配默认DEFAULT_CAPACITY = 10的初始容量
 *3:数组的长度是有限制的，而ArrayList是可以存放任意数量对象，长度不受限制，那么他是怎么实现的呢？
 *   数组扩容的方式去实现的。
 *4:能具体说下1.7和1.8版本初始化的时候的区别么？
 *  arrayList1.7开始变化有点大，一个是初始化的时候，1.7以前会调用this(10)才是真正的容量为10，1.7即本身以后是默认走了空数组，只有第一次add的时候容量会变成10。
 *5:ArrayList的默认数组大小为什么是10？
 * 据说是因为sun的程序员对一系列广泛使用的程序代码进行了调研，
 * 结果就是10这个长度的数组是最常用的最有效率的。也有说就是随便起的一个数字，8个12个都没什么区别，只是因为10这个数组比较的圆满而已。
 *6:我记得你说到了，他增删很慢，你能说一下ArrayList在增删的时候是怎么做的么？主要说一下他为啥慢
 *  他有指定index新增，也有直接新增的，在这之前他会有一步校验长度的判断ensureCapacityInternal，就是说如果长度不够，
 *  是需要扩容的。在扩容的时候，老版本的jdk和8以后的版本是有区别的，8之后的效率更高了，采用了位运算，右移一位，其实就是除以2这个操作。
 *  1.7的时候3/2+1 ，1.8直接就是3/2。指定位置新增的时候，在校验之后的操作很简单，就是数组的copy，至于为啥说他效率低，我想我不说你也应该知道了，
 *  我这只是在一个这么小的List里面操作，要是我去一个几百几千几万大小的List新增一个元素，那就需要后面所有的元素都复制，然后如果再涉及到扩容啥的就更慢了不是嘛。
 *7:ArrayList（int initialCapacity）会不会初始化数组大小？(重要)
 * 会初始化数组大小！但是List的大小没有变，因为list的大小是返回size的。
 *8:ArrayList插入删除一定慢么？
 * 取决于你删除的元素离数组末端有多远，ArrayList拿来作为堆栈来用还是挺合适的，push和pop操作完全不涉及数据移动操作
 *9:那他的删除怎么实现的呢?
 * 删除其实跟新增是一样的，不过叫是叫删除，但是在代码里面我们发现，他还是在copy一个数组
 *10:为啥是copy数组呢？
 * 删除下面这个数组中的index5这个位置 那代码他就复制一个index5+1开始到最后的数组，然后把它放到index开始的位置
 * index5的位置就成功被”删除“了其实就是被覆盖了，给了你被删除的感觉。同理他的效率也低，因为数组如果很大的话，一样需要复制和移动的位置就大了
 * 11:ArrayList是线程安全的么？
 * 当然不是，线程安全版本的数组容器是Vector。Vector的实现很简单，就是把所有的方法统统加上synchronized就完事了。
 * 你也可以不使用Vector，用Collections.synchronizedList把一个普通ArrayList包装成一个线程安全版本的数组容器也可以，
 * 原理同Vector是一样的，就是给所有的方法套上一层synchronized。//// new CopyOnWriteArrayList<>();这个
 * 12:ArrayList用来做队列合适么？
 * 队列一般是FIFO（先入先出）的，如果用ArrayList做队列，就需要在数组尾部追加数据，数组头部删除数组，反过来也可以
 * 但是无论如何总会有一个操作会涉及到数组的数据搬迁，这个是比较耗费性能的。结论：ArrayList不适合做队列。
 * 13:那数组适合用来做队列么？数组是非常合适的 比如ArrayBlockingQueue内部实现就是一个环形队列，它是一个定长队列，内部是用一个定长数组来实现的。
 * 14:ArrayList的遍历和LinkedList遍历性能比较如何？
 * 论遍历ArrayList要比LinkedList快得多，ArrayList遍历最大的优势在于内存的连续性，CPU的内部缓存结构会缓存连续的内存片段，可以大幅降低读取内存的性能开销。
 * ArrayList就是动态数组，用MSDN中的说法，就是Array的复杂版本，它提供了动态的增加和减少元素，实现了ICollection和IList接口，灵活的设置数组的大小等好处
 *
 *
 * 注意hashset,HashMap,ConcurrentHashMap面试相关问题
 *
 *
 * 集合线程不安全的问题
 *
 * 1.故障现象
 * ConcurrentModificationException（并发修改异常）
 * 2导致原因
 *
 * 3解决办法
 * 3.1 new Vector<>();
 * 3.2 Collections.synchronizedList(new ArrayList<>())
 * 3.3 new CopyOnWriteArrayList<>();
 *
 * 4优化建议
 *
 *
 */
public class NotSafeDemon3 {

    public static void main(String[] args) {



    }
    public static void mapNoSafe()
    {
        Map<String,String> map = new ConcurrentHashMap<>();//new HashMap<>();
        for (int i = 30; i > 0; i--) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,7));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
    public static void setNoSafe()
    {
        Set<String> set = new CopyOnWriteArraySet<>();//new HashSet<>();
        for (int i = 30; i > 0; i--) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set.toString());
            },String.valueOf(i)).start();
        }
    }
    public static void listNoSafe()
    {
        List<String> list = new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>());//new Vector<>();//new ArrayList<>();
        for (int i = 30; i > 0; i--) {
            new Thread(()-> {
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
