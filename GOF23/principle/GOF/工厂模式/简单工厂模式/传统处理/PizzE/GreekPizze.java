package com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/11 23:26
 * @Description :
 */
//具体类
public class GreekPizze extends Pizze{

  @Override
  public void prepare() {
    setName("GreekPizze");
    System.out.println(name+"preparing");
  }
}
