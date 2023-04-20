package com.lidadaibiao.JUC.GOF23.principle.GOF.单例模式.同步代码块懒汉式;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/9 23:35
 * @Description :
 */
public class SingleTon05 {

  public static void main(String[] args) {

  }
}

class SingleTon{
  private static SingleTon instance;
  private SingleTon(){

  }
  //增加同步代码块
  public static SingleTon getInstance(){
    if (instance==null){
      synchronized (SingleTon.class){
        instance = new SingleTon();
      }
    }
    return instance;
  }
}

/**
 * 优缺点：
 * 1：该方式，无法起到同步并不能起到线程同步的作用。和懒汉式线程不安全遇到情形一样
 * 当一个线程进入if中，还未来得及进行下一步。另一个线程也通过的if。这个时候照样会产生多个实例
 * 2：实际开发不可使用该方式
 */