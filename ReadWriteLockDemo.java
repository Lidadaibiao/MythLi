package com.lidadaibiao.JUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Mycahe
{

    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void write(String k,Object v)
    {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t----正在写入数据"+k);
            map.put(k,v);
            System.out.println(Thread.currentThread().getName()+"\t----写入数据完成");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            readWriteLock.writeLock().unlock();
        }

    }
    public void read(String k)
    {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t----正在读取数据");
            Object result = map.get(k);
            System.out.println(Thread.currentThread().getName()+"\t-----读取完成"+result);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }

    }


}

/**
 * @author Lidadaibiao
 * @date 2020/6/12 - 22:27
 *
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源的应该可以同时进行
 * 但是
 * 如果有一个线程想去写共享资源，就不应该再有其他的线程可以对该资源进行读或者写
 *
 * 小总结，
 *     读--读可以共存
 *     读--写不可以共存
 *     写--写不可以共存
 *
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        Mycahe mycahe = new Mycahe();
        for (int i = 5; i > 0; i--) {
            final int a = i; //这句话是因为lamda表达式语法要求
            new Thread(()->{

                mycahe.write(a+"",a+"");
            },String.valueOf(i)).start();
        }
        for (int i = 5; i > 0; i--) {
            final int a = i;
            new Thread(()->{
                //这句话是因为lamda表达式语法要求
                mycahe.read(a+"");
            },String.valueOf(i)).start();
        }
    }
}
