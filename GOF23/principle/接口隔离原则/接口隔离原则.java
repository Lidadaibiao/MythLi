package com.lidadaibiao.JUC.GOF23.principle.接口隔离原则;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/3/21 22:50
 * @Description :客户端不应该依赖他不需要的接口，即一个类对另一个类的依赖应该建立在最小的接口上。
 */
public class 接口隔离原则 {

}

interface Interface1 {
  void opteration1();
  void opteration2();
  void opteration3();
  void opteration4();
  void opteration5();
}
class B implements Interface1{

  @Override
  public void opteration1() {
    System.out.println("opteration1");
  }

  @Override
  public void opteration2() {
    System.out.println("opteration2");

  }

  @Override
  public void opteration3() {
    System.out.println("opteration3");

  }

  @Override
  public void opteration4() {
    System.out.println("opteration4");

  }

  @Override
  public void opteration5() {
    System.out.println("opteration5");
  }
}
class D implements Interface1{

  @Override
  public void opteration1() {
    System.out.println("opteration1");
  }

  @Override
  public void opteration2() {
    System.out.println("opteration2");

  }

  @Override
  public void opteration3() {
    System.out.println("opteration3");

  }

  @Override
  public void opteration4() {
    System.out.println("opteration4");

  }

  @Override
  public void opteration5() {
    System.out.println("opteration5");
  }
}
/**
 * A类通过接口Interface1 依赖使用B类，但是置灰用到1,2,3方法
 */
class A{
  public void depend1(Interface1 interface1){
    interface1.opteration1();
  }
  public void depend2(Interface1 interface1){
    interface1.opteration2();
  }
  public void depend3(Interface1 interface1){
    interface1.opteration3();
  }
}
/**
 * C类通过接口Interface1 依赖使用B类，但是置灰用到1,3,5方法
 */
class C{
  public void depend1(Interface1 interface1){
    interface1.opteration1();
  }
  public void depend3(Interface1 interface1){
    interface1.opteration3();
  }
  public void depend5(Interface1 interface1){
    interface1.opteration5();
  }
}
