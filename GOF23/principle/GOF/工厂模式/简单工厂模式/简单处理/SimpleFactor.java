package com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.简单处理;

import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE.CheesePizza;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE.GreekPizze;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE.Pizze;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/11 23:46
 * @Description :
 */
public class SimpleFactor {
  //根据orderType 返回pizze
  public Pizze createPizze(String orderType){
    Pizze pizze = null;
    System.out.println("实用简单工厂模式");
    if (orderType.equals("greek")){
      pizze=new GreekPizze();
    }else if (orderType.equals("cheese")){
      pizze=new CheesePizza();
    }
    return pizze;
  }
}
