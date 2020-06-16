package com.lidadaibiao.JUC.ThreadPoolDemon;

import java.util.concurrent.*;

/**
 * @author Lidadaibiao
 * @date 2020/6/15 - 16:43
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService e1 = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //AbortPolicy(默认)：直接抛出RejectedExecutionException异常阻止系统正常运行
        //CallerRunsPolicy：“调用者运行”一种调节机制，该策略既不会抛弃任务，也不
        //会抛出异常，而是将某些任务回退到调用者，从而降低新任务的流量。
        //DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务加人队列中
        //尝试再次提交当前任务。
       //DiscardPolicy：该策略默默地丢弃无法处理的任务，不予任何处理也不抛出异常。
       // 如果允许任务丢失，这是最好的一种策略。

            try {
                for (int i = 120; i > 0; i--) {
                    e1.execute(()->{
                        System.out.println(Thread.currentThread().getName()+"\t办理业务");
                    });
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }finally {
                e1.shutdown();
            }


    }
    //工作都不用
    public static void NoDo()
    {
        //执行长期任务性能好，创建一个线程池，
        //一池有N个固定的线程，有固定线程数的线程
        //ExecutorService executorService = Executors.newFixedThreadPool(5);//五个线程 就每次固定设置的个数，执行
        //一个任务一个任务的执行，一池一线程
        /// /ExecutorService executorService = Executors.newSingleThreadExecutor();//固定每次一个线程
        //执行很多短期异步任务，线程池根据需要创建新线程，
        //但在先前构建的线程可用时将重用它们。可扩容，遇强则强
        ExecutorService executorService = Executors.newCachedThreadPool();
        //模拟银行办理业务
        //现在有10个用户
        try {
            for (int i = 10; i > 0; i--) {
                TimeUnit.SECONDS.sleep(1);
                executorService.execute(()->{

                    System.out.println(Thread.currentThread().getName()+"\t来办理业务-----");

                });
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

    }
}
/**
 * 例子：
 * 10年前单核CPU电脑，假的多线程，像马戏团小丑玩多个球，CPU需要来回切换。
 * 现在是多核电脑，多个线程各自跑在独立的CPU上，不用切换效率高。
 *
 *
 * 线程池的优势：
 * 线程池做的工作只要是控制运行的线程数量，处理过程中将任务放入队列，然后在线程创建后启动这些任务，如果线程数量超过了最大数量，超出数量的线程排队等候，等其他线程执行完毕，再从队列中取出任务来执行。
 *
 * 它的主要特点为：线程复用;控制最大并发数;管理线程。
 *
 * 第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的销耗。
 * 第二：提高响应速度。当任务到达时，任务可以不需要等待线程创建就能立即执行。
 * 第三：提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会销耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控。
 *
 * newFixedThreadPool创建的线程池corePoolSize和maximumPoolSize值是相等的，它使用的是LinkedBlockingQueue
 * newSingleThreadExecutor 创建的线程池corePoolSize和maximumPoolSize值都是1，它使用的是LinkedBlockingQueue
 * newCachedThreadPool创建的线程池将corePoolSize设置为0，将maximumPoolSize设置为Integer.MAX_VALUE，它使用的是SynchronousQueue，也就是说来了任务就创建线程运行，当线程空闲超过60秒，就销毁线程。
 * */