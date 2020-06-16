package com.lidadaibiao.JUC.ThreadCommunication;


import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyPrint
{
    private int number = 0;//标志位 0--》A 1-->B 2-->C
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void A()
    {
        lock.lock();
        try {
            //判断
            while (number!=0)
            {
                c1.await();
            }
            //干活
            for (int i = 5; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+"\t--->"+i);
            }
            number = 1;
            //通知B
            c2.signal();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void B()
    {
        lock.lock();
        try {
            //判断
            while (number!=1)
            {
                c2.await();
            }
            //干活
            for (int i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+"\t--->"+i);
            }
            number=2;
            //通知C
            c3.signal();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void C()
    {
        lock.lock();
        try {
            //判断
            while (number!=2)
            {
                c3.await();
            }
            //干活
            for (int i = 3; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+"\t---->"+i);
            }
            //改变标示位
            number=0;
            //通知
            c1.signal();
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
 * 线程间 定制化调用接口
 * 比如：A 输出1-5
 * 比如：B 输出1-10
 *      C 输出 1-2
 * 顺序必须一致循环5次
 *
 *
 * @author Lidadaibiao
 * @date 2020/6/14 - 15:23
 */
public class ProdConsumerDemon2 {
    public static void main(String[] args) {
        MyPrint myPrint=new MyPrint();
        for (int i = 10; i > 0; i--) {
            new Thread(()->{
                myPrint.A();
            },"A").start();
            new Thread(()->{     myPrint.B();},"B").start();
            new Thread(()->{     myPrint.C();},"C").start();
        }

    }
}
