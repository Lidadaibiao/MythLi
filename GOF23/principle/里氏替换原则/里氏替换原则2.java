package com.lidadaibiao.JUC.GOF23.principle.里氏替换原则;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/3/28 23:35
 * @Description :
 *              问题引出：
 *              1）继承包含这样一层含义：父类凡是已经实现好的方法，实际上是在设置规范和契约
 *              虽然不强制所有的子类必须遵循。但是如果子类对这些已经实现的方法进行任意的修改
 *              就会对整个继承体系造成破坏。
 *              2）继承对程序设计有利也有弊。继承使用时带来的侵入性，程序可移植性也低，同时对象间高耦合。
 *              A（父类） 被B和C继承。如果A有更改，BC功能可能产生故障
 *              ---》为了正确使用继承，引入里氏替换原则：
 *              a:尽量不要重写父类的方法
 *              b:继承实际让两个类更加耦合，在适当情况下，可以通过聚合，组合，依赖来解决问题
 */
public class 里氏替换原则2 {

  public static void main(String[] args) {
    A2 a = new A2();
    System.out.println("11-3="+a.func1(11,3));
    System.out.println("1-8="+a.func1(1,8));

    System.out.println("----------------------");
    B2 b = new B2();
    System.out.println("11-3="+b.func1(11,3)); //这里程序员本意是11-3  但是忘记已经重写了A的方法
    System.out.println("1-8="+b.func1(1,8));
    System.out.println("11+3+10="+b.func2(11,3));
  }
}

/**
 * -----------------------举例说明
 */

class Base{
  //更加基础的类，更加基础的方法和成员放在base类
}


class A2 extends Base{

  /**
   * 返回两个数的差
   * @param num1
   * @param num2
   * @return
   */
  public int func1(int num1,int num2){
    return num1-num2;
  }
}
/**
 * B类继承A
 * 本意：增加一个新功能，两数相加，然后和10求和
 */
class B2 extends Base{
  //如果B2需要A2的方法 可以通过组合
  private A2 a2 = new A2();

  public int func1(int a,int b){
    return a+b;
  }
  public int func2(int a,int b){
    return func1(a,b)+10;
  }
  //假如我们仍然想使用A2的方法
  public int func3(int a,int b){
    return this.a2.func1(a,b);
  }
}

/**
 * 解决方法：
 *        1）我们明显发现原来正常的相减功能被我们重写之后发生的错误。在实际变成中，我们常常会通过重写父类的
 *        方法完成新的功能，虽然简单，但是整个继承体系复用性极差。特别是运行多态比较繁琐的时候。
 *        2）通俗的做法：原来父类和子类都继承一个更通俗的基类。或者继承关系去掉采用依赖，聚合，组合等关系代替。
 */