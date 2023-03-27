package com.lidadaibiao.JUC.GOF23.principle.依赖倒转原则;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/3/27 16:22
 * @Description :1：高层模块不可依赖底层模块，二者都应该依赖抽象
 *               2：抽象不应该依赖细节，细节应该依赖抽象
 *               3：依赖倒转的中心思想就是面向对象
 *               4：相对于细节的多边形，抽象要稳定的多。以抽象为基础的架构要比以依赖细节的架构稳定的多。在JAVA
 *               中抽象一般指的是接口和抽象类，细节就是具体的实现类
 *               5：使用接口和抽象类就是要提前制定好规则，而不是涉及具体的操作。把展现细节的任务交给他们实现类
 *               去完成。
 *               应用实例：向person类发送信息
 */
public class 依赖倒转原则 {

  public static void main(String[] args) {
    Person p = new Person();
    p.receive(new Email());
  }
}
class Email{
  public String getInfo(){
   return "Emali:收到了一个信息";
  }
}
/**
 * 完成一个person接收消息的功能
 * 1：方法1
 *    :简单，比较容易想到
 *    ：如果我们获取的对象是微信，短信等。则新增类，同时person也要增加相应的类
 *    ：解决思路：引入一个抽象的接口IReciver 表示接收者，这样person与接口发生依赖
 *    因为email wechat sms等都属于接收的范围，他们各自实现IReciver接口就OK ，这样就符合了依赖倒转原则
 */
class Person{
  public void receive(Email email){
    System.out.println(email.getInfo());
  }
}