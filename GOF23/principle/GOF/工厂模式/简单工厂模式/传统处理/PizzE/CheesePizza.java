package com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/11 23:25
 * @Description :
 */
//具体类
public class CheesePizza extends Pizze{

  @Override
  public void prepare() {
    setName("奶酪披萨");
    System.out.println(name+"preparing");
  }
}
