package com.lidadaibiao.JUC.GOF23.principle.接口隔离原则;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/3/21 22:50
 * @Description :客户端不应该依赖他不需要的接口，即一个类对另一个类的依赖应该建立在最小的接口上。
 */
public class 接口隔离原则2 {

}

interface Interface11 {
  void opteration1();
  void opteration3();
}
interface Interface2 {
  void opteration2();
}
interface Interface3 {
  void opteration5();
}
class BB implements Interface11,Interface2{

  @Override
  public void opteration1() {
    System.out.println("opteration1");
  }

  @Override
  public void opteration3() {
    System.out.println("opteration3");

  }

  @Override
  public void opteration2() {
    System.out.println("opteration2");

  }
}
class DD implements Interface11,Interface3{


  @Override
  public void opteration1() {
    System.out.println("opteration1");

  }

  @Override
  public void opteration3() {
    System.out.println("opteration3");

  }

  @Override
  public void opteration5() {
    System.out.println("opteration5");

  }
}
/**
 * A类通过接口Interface1 依赖使用B类，但是置灰用到1,2,3方法
 */
class AA{
  public void depend1(Interface11 interface1){
    interface1.opteration1();
  }
  public void depend2(Interface11 interface1){
    interface1.opteration3();
  }
  public void depend3(Interface2 interface1){
    interface1.opteration2();
  }
}
/**
 * C类通过接口Interface1 依赖使用B类，但是置灰用到1,3,5方法
 */
class CC{
  public void depend1(Interface11 interface1){
    interface1.opteration1();
  }
  public void depend3(Interface11 interface1){
    interface1.opteration3();
  }
  public void depend5(Interface3 interface1){
    interface1.opteration5();
  }
}
