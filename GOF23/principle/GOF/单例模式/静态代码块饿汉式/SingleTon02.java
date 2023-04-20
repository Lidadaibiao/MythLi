package com.lidadaibiao.JUC.GOF23.principle.GOF.单例模式.静态代码块饿汉式;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/9 23:21
 * @Description :
 */
public class SingleTon02 {

  public static void main(String[] args) {
    SingleTon singleTon1 = SingleTon.getInstance();
    SingleTon singleTon2 = SingleTon.getInstance();
    System.out.println(singleTon1 == singleTon2);
    System.out.println(singleTon1.hashCode());
    System.out.println(singleTon2.hashCode());
  }
}

class SingleTon{
    //1：构造器私有化，外部可new
  private SingleTon(){

  }
  //2.本类内部创建对象实例
  private static SingleTon instance;

  //3.静态代码块中，创建单例对象
  static {
    instance= new SingleTon();
  }

  //4 提供一个公有的静态方法，返回实例对象
  public static SingleTon getInstance(){
    return instance;
  }

}

/**
 * 优缺点
 * 1：这种方式和静态常量类似，只不过将类的实例化过程放入到静态代码块中，也是在类装载
 * 的时候，就执行静态代码块的代码，初始化类的实例。优缺点同上
 * 2：可能造成内存浪费
 */