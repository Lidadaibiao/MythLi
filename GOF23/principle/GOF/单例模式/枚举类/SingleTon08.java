package com.lidadaibiao.JUC.GOF23.principle.GOF.单例模式.枚举类;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/9 23:49
 * @Description :
 */
public class SingleTon08 {

  public static void main(String[] args) {
    SingleTon instacne = SingleTon.INSTACNE;
    SingleTon instacne1 = SingleTon.INSTACNE;
    System.out.println(instacne == instacne1);
    System.out.println(instacne.hashCode());
    System.out.println(instacne1.hashCode());
    instacne.sayOk();
  }
}
enum SingleTon{
  INSTACNE;
  public void sayOk(){
    System.out.println("ok~~~~");
  }
}
/**
 * 枚举实现
 * 优缺点：
 * 1：借助了JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题。
 * 而且还能反之反序列化重新创建新的对象
 * 2：这种方式是Effective JAVA坐着Josh Bloch提倡方式
 * 3：推荐使用
 */