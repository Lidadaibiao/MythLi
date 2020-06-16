package com.lidadaibiao.JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Lidadaibiao
 * @date 2020/6/12 - 23:22
 */
public class BlockingQueueDemon {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);//3为临界值



        //异常组
        //Exception in thread "main" java.lang.IllegalStateException: Queue full
/*        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));*/
        //System.out.println(blockingQueue.add("d"));
        //Exception in thread "main" java.util.NoSuchElementException
/*        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());*/
        //System.out.println(blockingQueue.remove());
    /*    System.out.println(blockingQueue.element());//检查一下队列
    * */
        //特殊组
      /*  System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("a"));//false*/

      /*  System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());//null*/

       /* System.out.println(blockingQueue.peek());//检查*/
        //阻塞祖
      /*  blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d");//一直阻塞，程序不会停 直到能够put进去

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());//同理*/

        //超时
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d",4, TimeUnit.SECONDS));//设置超时时间 如果阻塞过了4秒则放弃 加入

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(4,TimeUnit.SECONDS));//设置超时时间，如果阻塞超过了4秒 则放弃提取
    }
}
