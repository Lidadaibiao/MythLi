package com.lidadaibiao.JUC.GOF23.principle.GOF.单例模式.线程安全懒汉式;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/9 23:30
 * @Description :
 */
public class SingleTon04 {

  public static void main(String[] args) {
    SingleTon singleTon =SingleTon.getInstance();
    SingleTon singleTon1 = SingleTon.getInstance();
    System.out.println(singleTon1 == singleTon);
    System.out.println(singleTon1.hashCode());
    System.out.println(singleTon.hashCode());
  }
}

class SingleTon{
  private static SingleTon instance;

  private SingleTon(){

  }
  //提供一个同步处理的代码，解决线程安全问题
  public static synchronized SingleTon getInstance(){
    if (instance==null){
     instance = new SingleTon();
    }
    return instance;
  }
}
/**
 * 优缺点：
 * 1：解决了线程不安全的问题
 * 2：但是效率过低，每个线程想要获得类的实例时候，执行getinstance的时候
 * 都要进行同步。但是这个方法只需要同步一次就可，后面获得实例直接return就可
 * 方法进行同步效率太低
 * 3：实际开发不推荐使用该方式
 */