package com.lidadaibiao.JUC.CallableDemon;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class Mythread implements Callable<String>
{

    @Override
    public String call() throws Exception {

        System.out.println(Thread.currentThread().getName()+"come in ``````````");
        //暂定一会线程
        TimeUnit.SECONDS.sleep(2);
        return "实现callable接口";
    }
}

/**
 *
 *
 * 实现线程第三种方式，实现Callable接口
 *
 * FutureTask是什么？？
 * 未来的任务，用它就干一件事，异步调用main方法，就像一个冰糖葫芦，一个个方法由main串起来。
 * 但解决不了一个问题：正常调用挂起堵塞问题
 * 例子：
 * 1）老师上着课，口渴了，去买水不合适，讲课线程继续，我可以单起个线程找班长帮忙买水，
 * 水买回来了放桌上，我需要的时候再去get。
 * （2）4个同学，A算1+20,B算21+30,C算31*到40,D算41+50，是不是C的计算量有点大啊，
 * FutureTask单起个线程给C计算，我先汇总ABD，最后等C计算完了再汇总C，拿到最终结果
 * （3）高考：会做的先做，不会的放在后面做
 *FutureTask原理？
 * 在主线程中需要执行比较耗时的操作时，但又不想阻塞主线程时，可以把这些作业交给FutureTask对象在后台完成，
 * 当主线程将来需要时，就可以通过Future对象获得后台作业的计算结果或者执行状态。
 *一般FutureTask多用于耗时的计算，主线程可以在完成自己的任务后，再去获取结果。
 * 仅在计算完成时才能检索结果；如果计算尚未完成，则阻塞 get 方法。一旦计算完成，
 * 就不能再重新开始或取消计算。
 * get方法而获取结果只有在计算完成时获取，否则会一直阻塞直到任务转入完成状态，
 * 然后会返回结果或者抛出异常    只计算一次get方法放到最后
 * @author Lidadaibiao
 * @date 2020/6/15 - 14:16
 */
public class CallableDemon1 {

    public static void main(String[] args) throws Exception {

        Mythread mythread = new Mythread();

        FutureTask<String> runnable = new FutureTask<>(mythread);

        //new Thread(runnable,"A").start();
        new Thread(runnable,"B").start();
        System.out.println(Thread.currentThread().getName()+"\t计算完成-------");
        System.out.println(runnable.get());


    }
}
/**
 * 面试题:callable接口与runnable接口的区别？
 * 答：（1）是否有返回值
 *      (2）是否抛异常
 *      (3）落地方法不一样，一个是run，一个是call
 *
 *
 * 面试题：获得多线程的方法几种？
 * （1）继承thread类（2）runnable接口,如果只回答这两个你连被问到juc的机会都没有
 *正确答案如下：
 * 传统的是继承thread类和实现runnable接口，
 * java5以后又有实现callable接口和java的线程池获得
 *
 *
 * 直接替换runnable是否可行?
 * 不可行，因为：thread类的构造方法根本没有Callable
 * 认识不同的人找中间人
 * 这像认识一个不认识的同学，我可以找中间人介绍。中间人是什么？java多态，一个类可以实现多个接口！！
 * FutureTask<Integer>ft=newFutureTask<Integer>(newMyThread());
 * newThread(ft,"AA").start();
 * 运行成功后如何获得返回值？
 * ft.get();
 **/