package com.lidadaibiao.JUC.GOF23.principle.GOF.单例模式.静态常量饿汉式;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/9 23:11
 * @Description : 基本步骤：
 *                1：构造器私有化（防止new）
 *                2：类的内部创建对象
 *                3：向外暴露一个静态的公共方法 (返回一个该类的实例)
 */
public class SingleTon01 {

  public static void main(String[] args) {
      //测试
    SingleTon singleTon1 = SingleTon.getInstance();
    SingleTon singleTon2 = SingleTon.getInstance();
    System.out.println(singleTon1 == singleTon2);
  }
}

//饿汉式 静态常量
class SingleTon{
  //1 构造器私有化，外部可以New
  private SingleTon(){

  }
  //2 本类的内部创建对象实例
  private final static SingleTon instance = new SingleTon();

  //3提供一个静态方法，返回实例对象
  public static SingleTon getInstance(){
    return instance;
  }


}
/**
 * 优缺点：
 * 1：优点：写法简单，就是类装载的时候就完成的实例化。避免了线程同步问题
 * 2：缺点：在类装载的时候就完成了实例化，未达到Lazy  Loading的效果。
 * 如果从始至终未用到该类，就会造成内存的浪费。
 * 3：这种基于ClassLoader机制避免了多线程的同步问题，不过，Instance在类装载时就
 * 实例化，在单例模式中大多数都是调用getInstance方法，但是导致类装载的原因有很多种。
 * 因此无法确定有其它的方式（或者其他的静态方法）导致类装载，这个时候初始化Instance就
 * 没有达到Lazy loding的效果
 * 4：结论：这种单例模式可用，但是可能造成内存浪费。
 *
 *
 *
 *
 */