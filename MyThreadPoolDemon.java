package com.lidadaibiao.JUC;

import java.util.concurrent.*;

/**
 *
 * 线程池
 *
 * @author Lidadaibiao
 * @date 2020/6/13 - 21:43
 */
public class MyThreadPoolDemon {

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());//new ThreadPoolExecutor.DiscardPolicy());//new ThreadPoolExecutor.CallerRunsPolicy());//new ThreadPoolExecutor.AbortPolicy());
                try {
                    for (int i = 1; i <=220; i++) {
                        executorService.execute(()->
                        {
                            System.out.println(Thread.currentThread().getName()+"\t办理业务");
                        });
                    }
                }catch (Exception e)
                {
                    e.printStackTrace();
                }finally {
                    executorService.shutdown();
                }

    }
    public static void ThreadPoolSys()
    {
        ExecutorService executor = Executors.newFixedThreadPool(5);//一个线程池，有5个线程。相当于一个银行有5个办理窗口
        ExecutorService executor1 = Executors.newSingleThreadExecutor();//一个线程池一个线程
        ExecutorService executor2 = Executors.newCachedThreadPool();//一个线程池N个线程 类似一个银行N个工作窗口。就是会自动增加线程的意思
 /*     try {
            //模拟10个用户来银行办理业务，池子中有5个窗口提供工作服务
            for (int i = 10; i > 0; i--) {
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t  办理业务");
                });
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }*/
    /*  try {
            for (int i = 10; i > 0; i--) {
                executor1.execute(()->
                {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            executor1.shutdown();
        }*/
        try {
            for (int i = 10; i > 0; i--) {
                executor2.execute(()->
                {
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            executor2.shutdown();
        }
    }
}
