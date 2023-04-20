package com.lidadaibiao.JUC.GOF23.principle.GOF.单例模式.双重检查;
/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/9 23:38
 * @Description :
 */
public class SingleTon06 {

  public static void main(String[] args) {

  }
}

class SingleTon{
  private static volatile SingleTon instance;
  private SingleTon(){
  }
  public static SingleTon getInstance(){
    if (instance==null){
      synchronized (SingleTon.class){
        if (instance==null){
          instance = new SingleTon();
        }
      }
    }
    return instance;
  }

}

/**
 * 双重检查：
 * 优缺点：
 * 1：Double-Check概念是多线程开发中常使用到的，如代码块中所示，我们
 * 进行了两次if检查，这样保证了线程安全
 * 2：这样，实例化代码只用执行一次，后面再次执行访问时，判断if直接return
 * 避免了反复进行方法同步
 * 3：线程安全，延迟加载，效率较高。
 * 4：实际开发，推荐使用
 */