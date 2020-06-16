package com.lidadaibiao.JUC;

import java.util.concurrent.TimeUnit;

class Phone
{
    public static synchronized void sendEmail()throws Exception
    {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("sendEmial");
    }
    public static synchronized void sendSms()throws Exception{
        System.out.println("sendSMS");
    }
    public void sayHellow()
    {
        System.out.println("------hellow");
    }
}
/**
 * 8lock
 * 1:标准访问，请问先打印邮件还是短信
 * 2： 暂停4秒钟在邮件方法，请问先打印邮件还是短信
 * 3: 新增普通sayHello方法，请问先打印邮件还是Hello
 * 4: 两部手机，请问先打印邮件还是短信
 * 5：两个静态同步方法，同意不手机，请问先打印邮件还是短信
 * 6:两个静态同步方法，2部手机 请问先打印邮件还是短信
 * 7:1个静态同步方法，1个普通同步方法，同一部手机，请问先打印邮件还是短信
 * 8：1个静态同步方法，1个普通同步方法，2部手机，请问先打印邮件还是短信
 * @author Lidadaibiao
 * @date 2020/6/10 - 18:24
 */
public class Lock8Demon5 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();


        new Thread(()->{
            try {
                phone1.sendEmail();
            }catch (Exception e){
                e.printStackTrace();
            }
        },Thread.currentThread().getName()).start();
        Thread.sleep(100);
        new Thread(()->
        {
            try {
                phone2.sendSms();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        },Thread.currentThread().getName()).start();
    }
}
