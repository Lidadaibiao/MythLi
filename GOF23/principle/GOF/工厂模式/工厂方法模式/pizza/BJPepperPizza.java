package com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.pizza;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/12 23:17
 * @Description :
 */
public class BJPepperPizza extends Pizze{

  @Override
  public void prepare() {
    setName("北京胡椒披萨" );
    System.out.println("北京的胡椒披萨 准备原材料");
  }
}
