package com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.order;

import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.pizza.BJCheesePizza;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.pizza.BJPepperPizza;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.pizza.Pizze;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE.CheesePizza;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE.GreekPizze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/11 23:29
 * @Description :
 */
//北京订购
public  class BJOrderPizze extends OrderPizze{


  @Override
  Pizze createPizza(String orderType) {
    Pizze pizze = null;
    if (orderType.equals("cheese")){
      pizze=new BJCheesePizza();
    }else if (orderType.equals("perpper")){
      pizze=new BJPepperPizza();
    }
    return pizze;
  }
}
