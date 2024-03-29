package com.lidadaibiao.JUC.AuxiliaryClass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Lidadaibiao
 * @date 2020/6/15 - 16:20
 *
 *
 * 集齐七龙珠
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("龙珠集齐，召唤神龙");
        });

        for (int i = 7; i > 0; i--) {
            final  int a = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t集齐第"+(a-6)+"颗七龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
/**
 ** CyclicBarrier
* 的字面意思是可循环（Cyclic）使用的屏障（Barrier）。它要做的事情是，
* 让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
* 直到最后一个线程到达屏障时，屏障才会开门，所有
* 被屏障拦截的线程才会继续干活。
* 线程进入屏障通过CyclicBarrier的await()方法
 */
