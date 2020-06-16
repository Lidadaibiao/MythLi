package com.lidadaibiao.JUC;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Aircondition
{
   private int number = 0;
   private Lock lock = new ReentrantLock();
   private Condition condition = lock.newCondition();
   public void increment()
   {
       lock.lock();
       try {
           //判断
           while (number!=0)
           {
               condition.await();
           }
           //操作
           number++;
           System.out.println(Thread.currentThread().getName()+"\t---->"+number);
           //通知
           condition.signalAll();
       }catch (Exception e)
       {
           e.printStackTrace();
       }finally {
           lock.unlock();
       }
   }
   public void decrement()
   {
       lock.lock();
       try {
           while (number==0)
           {
               condition.await();
           }
           //操作
           number--;
           System.out.println(Thread.currentThread().getName()+"\t---->"+number);
           //通知
           condition.signalAll();
       }catch (Exception e)
       {
           e.printStackTrace();
       }finally {
           lock.unlock();
       }
   }



   //jdk1.8之前这样写
   /*public synchronized void increment() throws InterruptedException {
       //判断
       //if (number!=0)
       while (number!=0)
       {
           this.wait();
       }
       //操作
       number++;
       System.out.println(Thread.currentThread().getName()+"\t---->"+number);
        //通知
       this.notifyAll();
   }
   public synchronized void decrement() throws InterruptedException {
      // if (number==0)
       while (number==0)
       {
           this.wait();
       }
       number--;
       System.out.println(Thread.currentThread().getName()+"\t=----->"+number);
       this.notifyAll();
   }
*/
}
/**
 *
 *
 *
 * 生产者消费者问题：
 *
 * 题目：现在有两个线程，可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加一，另一个线程对该变量减一，
 * 实现交替来10轮，变量初始值为零
 * @author Lidadaibiao
 * @date 2020/6/10 - 20:00
 * 实现多线程交互
 * 1. 高内聚低耦合的前提下，线程操作资源类
 * 2. 判断/干活通知
 * 3. 线程交互条件判断 必须用while(官方API)
 *
 *知识总结= 多线程编程套路+while判断+新版本Lock写法
 */
public class ProdConsumerDemon04 {
    public static void main(String[] args) {
        //创建资源类
        Aircondition aircondition = new Aircondition();
        //创建线程
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"A").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"C").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
