package com.lidadaibiao.JUC.BlockingQueueDemon2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 * 简单说一下、
 * 栈和队列：
 * 栈：先进后出,吃的吐出来
 * 队列，先进先出，吃的拉出来
 *阻塞队列的用处：
 * 在多线程领域：所谓阻塞，在某些情况下会挂起线程（即阻塞），一旦条件满足，该挂起的线程又会自动唤醒
 * 为什么需要BlockingQueue
 * 好处是我们不需要关心什么时候需要阻塞线程，
 * 什么时候需要唤醒线程，因为这一切BlockingQueue都给你一手包办了
 *在concurrent包发布以前，
 *在多线程环境下，我们每个程序员都必须去自己控制这些细节，尤其还要兼顾效率和线程安全，而这会给我们的程序带来不小的复杂度。
 *
 *
 * @author Lidadaibiao
 * @date 2020/6/15 - 15:28
 */
public class BlockingQueuedemon {


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(3);//3为临界值  该队列中有3个空间


        //异常组
        //Queue full
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
//        blockingQueue.add("d");
//        System.out.println(blockingQueue);
        //Exception in thread "main" java.util.NoSuchElementException
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
        //blockingQueue.remove();
        //System.out.println(blockingQueue);
        //System.out.println(blockingQueue.element());
       /* System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.element());*/


       //特殊值
      /*  System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));
        System.out.println(blockingQueue);
        *//*System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));*//*
        System.out.println(blockingQueue.peek());*/


    /*    //阻塞
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        blockingQueue.take();
        blockingQueue.put("d");
        System.out.println(blockingQueue);

        blockingQueue.take();
        System.out.println(blockingQueue);*/


    //超时
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d", 3, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
    }
}
