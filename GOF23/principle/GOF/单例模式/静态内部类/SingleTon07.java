package com.lidadaibiao.JUC.GOF23.principle.GOF.单例模式.静态内部类;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/9 23:43
 * @Description :
 */
public class SingleTon07 {

}

class SingleTon{
  private SingleTon(){}
  //写一个静态内部类，该类中有个静态属性SingleTon
  private static class SingleTonInstance{
    private static final SingleTon INSTANCE = new SingleTon();
  }
  public static SingleTon getInstance(){
  return SingleTonInstance.INSTANCE;
  }
}

/**
 *  优缺点：
 *  1：这种方式采用了类装载的机制来保证初始化实例时只有一个线程
 *  2：静态内部类方式在SingleTon类被装载时，并不会立即实例化，而是在需要实例化时，
 *  调用getInstance,才会进行装载SingleTonInstance类，从而完成SingleTon的实例化
 *  3：类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们，保证了线程的安全性
 *  在类进行初始化时，别的线程是无法进入的。
 *  4：优点：避免了线程不安全，利用今天内部类的特点实现延迟加载，效率高
 *  5：推荐使用
 */