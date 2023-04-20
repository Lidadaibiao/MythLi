package com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.order;

import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.工厂方法模式.pizza.Pizze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/11 23:29
 * @Description :
 */
//订购披萨
public abstract class OrderPizze {

  //定义一个抽象方法，createPizza， 让各个工厂子类进行实现
  abstract Pizze createPizza(String orderType);
  //构造器
  public OrderPizze(){
    Pizze pizze = null;
    //订购披萨类型
    String orderType ;
    do{
      orderType=getType();
      pizze = createPizza(orderType);//抽象的 由工厂子类完成
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
