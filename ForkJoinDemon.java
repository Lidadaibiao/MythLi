package com.lidadaibiao.JUC;



import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class MyTask extends RecursiveTask<Integer>
{
    private static  final  int ADJUST_VALUE = 10;
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {


        if ((end-begin)<=ADJUST_VALUE)
        {
            for (int i = begin; i<=end;i++)
            {
                result = result+i;
            }
        }else
            {
                int middle = (end+begin)/2;
                MyTask myTask = new MyTask(begin,middle);
                MyTask myTask1 = new MyTask(middle+1,end);
                myTask.fork();
                myTask1.fork();
                result = myTask.join()+myTask1.join();
            }

        return result;
    }
}
/**
 *
 *
 * 分支合并思想
 * @author Lidadaibiao
 * @date 2020/6/14 - 10:45
 */
public class ForkJoinDemon {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0,100);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);
        System.out.println(forkJoinTask.get());
        forkJoinPool.shutdown();
    }
}
