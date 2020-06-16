package com.lidadaibiao.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class Mythread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("----comeinHere Callable");
        //暂定一会线程
        TimeUnit.SECONDS.sleep(4);
        return "111111111";
    }
}


/**
 * @author Lidadaibiao
 * @date 2020/6/12 - 20:58
 *
 *
 * 1：futureTask.get()一定要放到最后
 */
public class FutureTaskDeon6 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask<>(new Mythread());

        new Thread(futureTask,"AAA").start();
        System.out.println(Thread.currentThread().getName()+"\\\\\\\\\\\\\\\\\\\\\\\\\\");
        System.out.println(futureTask.get());

        //System.out.println(Thread.currentThread().getName()+"\\\\\\\\\\\\\\\\\\\\\\\\\\");


    }

}
