package com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.pizza;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/12 23:17
 * @Description :
 */
public class BJCheesePizza extends Pizze{

  @Override
  public void prepare() {
    setName("北京奶酪披萨" );
    System.out.println("北京的奶酪披萨 准备原材料");
  }
}
