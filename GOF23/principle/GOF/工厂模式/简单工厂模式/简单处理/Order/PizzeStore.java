package com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.简单处理.Order;

import com.lidadaibiao.JUC.GOF23.principle.GOF.工厂模式.简单工厂模式.简单处理.SimpleFactor;

/**
 * @Author : dadaibiaoli
 * @DateTime: 2023/4/11 23:54
 * @Description :
 */
public class PizzeStore {

  public static void main(String[] args) {
    OrderPizze orderPizze = new OrderPizze(new SimpleFactor());
  }
}
