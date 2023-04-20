package com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/11 23:23
 * @Description :
 */
//披萨的抽象类
public abstract class Pizze {
  protected String name;
  public void bake(){
    System.out.println("bake~~~~"+name);
  }
  public void cut(){
    System.out.println("cut~~~~"+name);
  }
  public void box(){
    System.out.println("box~~~~"+name);
  }
  //准备原材料，不同披萨不一样，因此，我们做成抽象方法
  public abstract void prepare();

  public void setName(String name){
    this.name=name;
  }
}
