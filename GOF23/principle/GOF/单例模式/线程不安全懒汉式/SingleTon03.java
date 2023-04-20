package com.lidadaibiao.JUC.GOF23.principle.GOF.单例模式.线程不安全懒汉式;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/9 23:26
 * @Description :
 */
public class SingleTon03 {

  public static void main(String[] args) {
    SingleTon singleTon = SingleTon.getInstance();
    SingleTon singleTon1 = SingleTon.getInstance();
    System.out.println(singleTon1 == singleTon);
    System.out.println(singleTon1.hashCode());
    System.out.println(singleTon.hashCode());
  }
}



class SingleTon{
  private static SingleTon instance;
  private SingleTon(){}
  //提供一个静态共有方法，当使用该方法时才去创建Instance
  public static SingleTon getInstance(){
    if (instance==null){
      instance= new SingleTon();
    }
    return instance;
  }
}

/**
 * 优缺点：
 * 1：起到了LazyLoding的效果，但是只能在单线程下使用
 * 2：如果在多线程下，一个线程进入了if的判断语句块中，还未来得及
 * 向下执行，另一个线程也通过了这个判断语句，这个时候就会产生多个
 * 实例所以多线程下是不可使用这种方式。
 * 3：实际开发中，不可使用该方式
 */