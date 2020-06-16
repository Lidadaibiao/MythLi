package com.lidadaibiao.JUC.What;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 *
 *
 * @author Lidadaibiao
 * @date 2020/6/14 - 13:27
 */
public class Introduce {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程的方式

        //第一种方式继承thread抽象类
        Mythread mythread = new Mythread();
        mythread.start();
        doSomeThing();


        //第二种方式实现Runnable接口
        Mythread2 mythread2 = new Mythread2();
        new Thread(mythread2).start();

        //第三种方式实现Callable接口
        Mythread3 mythread3 = new Mythread3();
        FutureTask<String> futureTask = new FutureTask<>(mythread3);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

    }
    public static void doSomeThing()
    {
        System.out.println(Thread.currentThread().getName()+"\tmain中的doSomeThing");
    }
}
class Mythread extends Thread
{
    @Override
    public void run() {
        doSomeThing();
    }

    public void doSomeThing()
    {
        System.out.println(Thread.currentThread().getName()+"\t线程创建1--继承thread-----");
    }
}
class Mythread2 implements Runnable
{

    @Override
    public void run() {
        doSomeThing();
    }
    public void doSomeThing()
    {
        System.out.println(Thread.currentThread().getName()+"\t线程创建2--实现runable接口-----");
    }
}
class Mythread3 implements Callable<String>
{

    @Override
    public String call() throws Exception {

        doSomeThing();
        return "需要返回的值";
    }
    public void doSomeThing()
    {
        System.out.println(Thread.currentThread().getName()+"\t线程创建3--Callable-----");
    }
}
/*

 */
/**
 * 进程：
 *      进程是一个具有一定独立功能的程序关于某个数据集合的一次运行活动。
 *      它是操作系统动态执行的基本单元，在传统的操作系统中，进程既是基本的分配单元，
 *       也是基本的执行单元。
 * 线程：
 *      通常在一个进程中可以包含若干个线程，
 *      当然一个进程中至少有一个线程，不然没有存在的意义。
 *      线程可以利用进程所拥有的资源，在引入线程的操作系统中，
 *      通常都是把进程作为分配资源的基本单位，而把线程作为独立运行和独立调度的基本单位，
 *      由于线程比进程更小，基本上不拥有系统资源，故对它的调度所付出的开销就会小得多，
 *      能更高效的提高系统多个程序间并发执行的程度
 * 例子： 使用QQ，查看进程一定有一个QQ.exe的进程，我可以用qq和A文字聊天，
 *        和B视频聊天，给C传文件，给D发一段语言，QQ支持录入信息的搜索。
 *        大四的时候写论文，用word写论文，同时用QQ音乐放音乐，
 *        同时用QQ聊天，多个进程。
 *          word如没有保存，
 *          停电关机，再通电后打开word可以恢复之前未保存的文档，
 *          word也会检查你的拼写，两个线程：容灾备份，语法检查
 *线程状态：NEW（新建），RUNNABLE（准备就绪）,BLOCKED（阻塞）,WAITING（不见不散）
 *        ,TIMED_WAITING（过时不候）,TERMINATED（终结）;
 *wait/sleep的区别：功能就是当前线程暂停，区别如下：
 *          wait:放开手去睡，放开手里的锁
 *          sleep:握住手去睡，不放开手里的锁。醒了手里依然有锁
 *并发和并行：
 *      并发：同一个时刻多个线程在访问同一个资源，多个线程对一个点。
 *      例子：秒杀，春运抢票，
 *      并行：多项工作一起执行，之后再汇总。
 *      例子：泡方便面的时候，同时烧水和加调料包
 *
 *
 */