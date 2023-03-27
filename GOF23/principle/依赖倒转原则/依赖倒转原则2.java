package com.lidadaibiao.JUC.GOF23.principle.依赖倒转原则;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/3/27 16:33
 * @Description :
 */
public class 依赖倒转原则2 {

  public static void main(String[] args) {
    Person2 person2 = new Person2();
    person2.receive(new Email2());
    person2.receive(new Wechat());
  }
}
interface IReceiver{
  public String getInfo();
}

class Email2 implements IReceiver{

  @Override
  public String getInfo() {
    return "Email:发送信息";
  }
}

class Wechat implements IReceiver{

  @Override
  public String getInfo() {
    return "Wechat:发送消息";
  }
}

class Person2{
  public void receive(IReceiver iReceiver){
    System.out.println(iReceiver.getInfo());
  }
}