package com.lidadaibiao.JUC.ReadWriteLockDemos;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyBook
{

    private Map<String,String> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void write(String key,String value) throws InterruptedException {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t正在向书中写内容~~~~~~~");
            TimeUnit.SECONDS.sleep(2);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t写完了~~~~~~~~~~~~~"+map);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }
    public void read(String key)
    {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t正在读取书中的内容");
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t读完了"+map.get(key));
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
        System.out.println(Thread.currentThread().getName()+"\t正在读取书中的内容");
        map.get(key);
        System.out.println(Thread.currentThread().getName()+"\t读完了"+map.get(key));
    }
}
/**
 * 读写锁
 * 多个线程同时去读取一个共享资源的时候，没有什么问题。所以为了满足并发量，读取共享资源的应该可以同时进行
 * 但是多个线程同时去写取一个共享资源的时候，就会有相应的安全问题，写入共享资源不可同时进行。
 * 小总结：
 *      读-读可以同时进行
 *      读-写不可以同时进行
 *      写-写不可以同时进行
 *
 *
 * @author Lidadaibiao
 * @date 2020/6/15 - 14:58
 */
public class ReadWriteLocakDemons {

    public static void main(String[] args) {
            MyBook myBook = new MyBook();
        for (int i = 5; i > 0; i--) {
            final int a = i;
            new Thread(()->{
                try {
                    myBook.write(a+"",a+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
        for (int i = 5; i > 0; i--) {
            final int a = i;
            new Thread(()->{
                myBook.read(a+"");
            },String.valueOf(i)).start();
        }

    }
}
