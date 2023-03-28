package com.lidadaibiao.JUC.NoSafeDemon;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 证明集合类不安全
 *
 * 1.出现错误
 * java.util.ConcurrentModificationException 并发修改异常
 * 2.出现原因
 * 并发过多导致 修改异常
 * 3.处理方法
 *  3.1 new Vector<>();
 *  3.2 Collections.synchronizedList(new ArrayList<>());
 *  3.3 new CopyOnWriteArrayList<>();
 *
 *
 * @author Lidadaibiao
 * @date 2020/6/14 - 16:25
 */
public class NoSafeConlletcionDemon {

    public static void main(String[] args) {

      NosafeMap();
    }
    public static void NosafeMap()
    {

        Map<String,String> map =new ConcurrentHashMap<>(); //Collections.synchronizedMap(new HashMap<>());//new Hashtable<>();//new HashMap<>();
        for (int i = 15; i > 0; i--) {
            new Thread(()->{
                map.put(UUID.randomUUID().toString().substring(0,2),UUID.randomUUID().toString().substring(0,3));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
    public static void NosafeSet()
    {
        Set<String> set = new CopyOnWriteArraySet<>();//Collections.synchronizedSet(new HashSet<>());//new HashSet<>();

        for (int i = 15; i > 0; i--) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
    public static void NosafeList()
    {
        List<String> list =new CopyOnWriteArrayList<>();//Collections.synchronizedList(new ArrayList<>());//new Vector<>();// new ArrayList<>();
        //java.util.ConcurrentModificationException 并发修改异常
        for (int i = 120; i > 0; i--) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
/**
 * CopyOnWriteArrayList写时复制
 * CopyOnWriteArrayList是arraylist的一种线程安全变体，
 * 其中所有可变操作（add、set等）都是通过生成底层数组的新副本来实现的。
 * 写时复制的原理和源码:
 *public booleanadd(Ee) {
 *      finalReentrantLock lock =this.lock;
 *       lock.lock();
 *    try{
 *      Object[] elements = getArray();
 *     intlen = elements.length;
 *       Object[] newElements = Arrays.copyOf(elements, len +1);
 *     newElements[len] = e;
 *      setArray(newElements);
 *     return true;
 *       }finally{
 *      lock.unlock();
 *      }
 *     }
 *     
 *     
 *      
 *    CopyOnWrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器Object[]添加，
 *    而是先将当前容器Object[]进行Copy，复制出一个新的容器Object[] newElements，
 *    然后向新的容器Object[] newElements里添加元素。
 *    添加元素后，再将原容器的引用指向新的容器setArray(newElements)。
 *    这样做的好处是可以对CopyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。
 *    所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器。
 *
 *
 */
