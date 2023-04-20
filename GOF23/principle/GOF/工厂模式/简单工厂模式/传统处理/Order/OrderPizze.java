package com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.Order;

import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE.CheesePizza;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE.GreekPizze;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE.Pizze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/11 23:29
 * @Description :
 */
//订购披萨
public class OrderPizze {
  //构造器
  public OrderPizze(){
    Pizze pizze = null;
    //订购披萨类型
    String orderType ;
    do{
      orderType=getType();
      if (orderType.equals("greek")){
        pizze=new GreekPizze();
      }else if (orderType.equals("cheese")){
        pizze=new CheesePizza();
      }else {
        break; //除了以上两种无法订购
      }
      //输出一个披萨的过程
      pizze.prepare();
      pizze.bake();
      pizze.cut();
      pizze.box();
    }while (true);
  }

  //写个方法 可以动态获取客户希望订购的方法
  private String getType(){
    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("input pizze type");
      String  str = bufferedReader.readLine();
      return str;
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }
}
