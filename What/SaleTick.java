package com.lidadaibiao.JUC.What;


import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket
{
    //票数
    private  int NUMBER=30;
    //第一种方式
   /* public synchronized void saleTick()
    {
        System.out.println(Thread.currentThread().getName()+"\t卖出了第:"+(NUMBER--)+"\t还剩："+NUMBER);
    }*/
    //第二种方式Lock锁
    private Lock lock = new ReentrantLock();
    public void saleTick()
    {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t卖出了第"+(NUMBER--)+"\t还剩--》"+NUMBER);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
/**
 *
 * 题目：三个售票员（保证安全） 卖出       30张票
 * 笔记:如何编写企业级多线程编程
 * 固定的编程套路和模板
 * 1.高内聚低耦合的前提下： 线程  操作  资源类
 * 1.1 一言不合创建一个资源类先
 * @author Lidadaibiao
 * @date 2020/6/14 - 13:53
 */
public class SaleTick {
    public static void main(String[] args) {
        //创建资源类

        Ticket ticket = new Ticket();
        //线程
        new Thread(()->
        {
            for (int i = 10; i > 0; i--) {
                //操作 资源类
                ticket.saleTick();
                //模拟一下时间

            }

        },"A").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                ticket.saleTick();
                //模拟一下时间

            }
        },"B").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                ticket.saleTick();
                //模拟一下时间

            }
        },"C").start();
    }
}
/**
 * Lock是一个接口，它的实现ReentrantLock可重入锁，
 * Lock锁:
 *      Lock实现提供了比使用同步方法和语句可以获得的更广泛的锁操作。
 *      它们允许更灵活的结构，可能具有非常不同的属性，并且可能支持多个关联的条件对象
 *
 * 两者区别：
 *    1.首先synchronized是java内置关键字，在jvm层面，Lock是个java类；
 *    2.synchronized无法判断是否获取锁的状态，Lock可以判断是否获取到锁；
 *    3.synchronized会自动释放锁(a 线程执行完同步代码会释放锁 ；b 线程执行过程中发生异常会释放锁)
 *    ，Lock需在finally中手工释放锁（unlock()方法释放锁），否则容易造成线程死锁；
 *   4.用synchronized关键字的两个线程1和线程2，如果当前线程1获得锁，
 *   线程2线程等待。如果线程1阻塞，线程2则会一直等待下去，
 *   而Lock锁就不一定会等待下去，如果尝试获取不到锁，线程可以不用一直等待就结束了；
 *     5.synchronized的锁可重入、不可中断、非公平，而Lock锁可重入、可判断、可公平（两者皆可）
     6.Lock锁适合大量同步的代码的同步问题，synchronized锁适合代码少量的同步问题。
 **/