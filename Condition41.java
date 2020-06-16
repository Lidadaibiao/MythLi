package com.lidadaibiao.JUC;




import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareDate
{
    //设置标志位
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();//我把C1 C2 C3看做信号量
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
/*    public void Myprint(String str)
    {
        lock.lock(); //上锁
        try {
            //判断
            while (!str.equals("AA"))
            {
                c1.await();//c1等待
            }
            //操作
            for (int i = 5; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+"\t-->"+i);
            }
            //改变标志位
            c2.signal();//精确唤醒c2
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }*/
    public void AA()
    {
        lock.lock(); //上锁
        try {
            //判断
            while (number!=1)
            {
                c1.await();//c1等待
            }
            //操作
            for (int i = 5; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+"\t-->"+i);
            }
            //改变标志位
            number = 2;
            c2.signal();//精确唤醒c2
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public  void BB()
    {
        lock.lock();
        try {
            //判断
            while (number!=2)
            {
                c2.await();
            }
            //操作
            for (int i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+"\t-->"+i);
            }
            //改变标志位
            number = 3;
            //精确唤醒c3
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public  void CC() {
        lock.lock();
        try {
            //判断
            while (number != 3) {
                c3.await();
            }
            //操作
            for (int i = 15; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + "\t--->" + i);
            }
            //改变标志位
            number = 1;
            //精确唤醒c1
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
/**
 *
 * lock    Condition实现了对数据的精确定位
 *
 * 题目：
 * 多线程之间按顺序调用，实现A-B-C
 * 三个线程启动。要求如下
 * A打印5次，B打印10次，C打印15次
 * 来10轮
 * @author Lidadaibiao
 * @date 2020/6/10 - 22:46
 */
public class Condition41 {

    public static void main(String[] args) {
        //创建资源类
        ShareDate shareDate = new ShareDate();

        //创建线程
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                shareDate.AA();
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                shareDate.BB();
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                shareDate.CC();
            }
        },"CC").start();
    }
}
