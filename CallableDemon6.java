package com.lidadaibiao.JUC;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer> //implements Runnable//extends Thread
{
    @Override
    public Integer call() throws Exception {
        System.out.println("-----实现了Callable的call方法");
        return 1111;
    }

   /* @Override
    public void run() {

    }*/
}

/**
 * 实现进程的第三种方式
 * @author Lidadaibiao
 * @date 2020/6/11 - 0:01
 */
public class CallableDemon6 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        futureTask.run();//启动线程
        System.out.println(futureTask.get());

    }
}
