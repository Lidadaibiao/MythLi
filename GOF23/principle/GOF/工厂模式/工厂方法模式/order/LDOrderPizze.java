package com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.order;

import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.pizza.BJCheesePizza;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.pizza.BJPepperPizza;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.pizza.LDCheesePizza;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.pizza.LDPepperPizza;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.pizza.Pizze;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/11 23:29
 * @Description :
 */
//北京订购
public  class LDOrderPizze extends OrderPizze{


  @Override
  Pizze createPizza(String orderType) {
    Pizze pizze = null;
    if (orderType.equals("cheese")){
      pizze=new LDCheesePizza();
    }else if (orderType.equals("perpper")){
      pizze=new LDPepperPizza();
    }
    return pizze;
  }
}
