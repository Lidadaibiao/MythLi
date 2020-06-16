package com.lidadaibiao.JUC;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket //资源类： 实现变量 + 实现方法
{
    private int number = 30;
    //lock比synchronized更好用。synchronized是一个悲观锁，重要锁   ReentrantLock为一个可重入锁，也就是方法可重新进入和使用。

    Lock lock = new ReentrantLock();
 /*   public synchronized void sale()
    {
        if(number>0)
        {
            System.out.println(Thread.currentThread().getName()+"\t卖出第:\t"+(number--)+"\t张票\t"+number+"\t为剩下票数");
        }
    }
*/


    public void sale()//实现方法
    {
        //加锁
        lock.lock();
        try {
            if(number>0)
            {
                System.out.println(Thread.currentThread().getName()+"\t卖出第:\t"+(number--)+"\t张票\t"+number+"\t为剩下票数");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
/**
 * 题目：三个售票员 卖出       30张票
 * 笔记:如何编写企业级多线程编程
 * 固定的编程套路和模板
 * 1.高内聚低耦合的前提下： 线程  操作  资源类
 *
 * 1.1 一言不合创建一个资源类先
 *
 *
 * @author Lidadaibiao
 * @date 2020/6/10 - 11:38
 */
public class SaleTickDemo1 {

    public static void main(String[] args) {//主线程  程序入口

        //创建资源
        Ticket ticket = new Ticket();

        //lamda表达式的写法
        new Thread(()->{for (int i = 0;i<=30;i++) { ticket.sale(); } },"A").start();
        new Thread(()->{for (int i = 0;i<=30;i++) { ticket.sale(); } },"B").start();
        new Thread(()->{for (int i = 0;i<=30;i++) { ticket.sale(); } },"C").start();
        //匿名内部类的写法
        //创建线程
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<=30;i++)
                {
                    ticket.sale();
                }
            }
        },"A").start();//操作资源
        //创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<=30;i++)
                {
                    ticket.sale();
                }
            }
        },"B").start();//操作资源
        //创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<=30;i++)
                {
                    ticket.sale();
                }
            }
        },"C").start();//操作资源
*/
    }
}
