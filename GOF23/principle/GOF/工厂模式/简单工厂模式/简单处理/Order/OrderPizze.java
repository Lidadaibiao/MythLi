package com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.简单处理.Order;

import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE.CheesePizza;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE.GreekPizze;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.传统处理.PizzE.Pizze;
import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.简单处理.SimpleFactor;
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
public class OrderPizze {

  //构造器
  public OrderPizze(SimpleFactor simpleFactor){
    setSimpleFactor(simpleFactor);
  }

  //定义一个简单工厂对象
  SimpleFactor simpleFactor;
  Pizze pizze = null;
  public void setSimpleFactor(SimpleFactor simpleFactor){
    String orderType = "";//用户输入

    this.simpleFactor = simpleFactor;//设置一个简单工厂对象

    do {
      orderType = getType();
      pizze = simpleFactor.createPizze(orderType);
      //输出披萨
      if (Objects.nonNull(pizze)){  //订购成功
        pizze.prepare();
        pizze.cut();
        pizze.box();
      }else {
        System.out.println("订购披萨失败，不存在该种类披萨");
        break;
      }
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
