package com.lidadaibiao.JUC.ThreadCommunication;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Print
{
    private int number = 0;
    private char c = 'A';
    private boolean b = false;

    private Lock lock = new ReentrantLock();
    private Condition con = lock.newCondition();
    public void ShuZi()
    {
        lock.lock();
        try {
            //判断
            while (b)
            {
                con.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t---->"+(number++));
            System.out.println(Thread.currentThread().getName()+"\t---->"+number);
            //改变标志位
            b = !b;
            //通知
            con.signalAll();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void ZiMu()
    {
        lock.lock();
        try {
            while (!b)
            {
                con.await();
            }
            System.out.println(Thread.currentThread().getName()+"\t--->"+(c++));
            //改变标示位
            b=!b;
            //通知
            con.signalAll();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    //使用加锁机制   synchronized
   /* public synchronized void ShuZi() throws InterruptedException {
        //判断
        while (b)
        {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"\t--->"+(number++));
        System.out.println(Thread.currentThread().getName()+"\t--->"+number);
        //改变标志位
        b = !b;
        //通知
        this.notifyAll();
    }
    public synchronized  void ZiMu() throws InterruptedException {
        //判断
        while (!b)
        {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()+"\t---->"+c++);
        //改变标志位
        b = !b;
        //通知
        this.notifyAll();
    }*/
}
/**
 *
 * 生产者消费者模式的一个复习
 * 两个线程，一个线程打印1-52，另一个打印字母A-Z打印顺序为12A34B...5152Z,
    要求用线程间通信


   步骤：
        判断+干活+通知
   为了防止虚假唤醒，判断的时候不能用If  必须用while
 * @author Lidadaibiao
 * @date 2020/6/14 - 14:58
 */
public class ProdConsumeDemon {
    public static void main(String[] args) {

        Print print = new Print();

        new Thread(()->{
            for (int i = 26; i > 0; i--) {
                try {
                    print.ShuZi();
                    //TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 26; i > 0; i--) {
                try {
                    print.ZiMu();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        },"B").start();
    }
}
